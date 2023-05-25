package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Avaliacao;
import backenddm20231n.util.ConexaoDb;

public class DaoAvaliacao {
	private final Connection c;

	public DaoAvaliacao() throws SQLException, ClassNotFoundException {
		this.c = ConexaoDb.getConexaoMySQL();
	}

	public Avaliacao inserir(Avaliacao entrada) throws SQLException {
		String sql = "insert into avaliacoes" + " (id_p, id_l, descricao, nota)" + " values (?,?,?,?);";
		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, entrada.getIdP());
		stmt.setInt(2, entrada.getIdL());
		stmt.setString(3, entrada.getDescricao());
		stmt.setInt(4, entrada.getNota());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			entrada.setId(id);
		}
		
		atualizarMediaLivro(entrada);

		stmt.close();
		return entrada;
	}

	private void atualizarMediaLivro(Avaliacao aval) throws SQLException {
		// Atualizando Média do Livro
		List<Integer> listaNota = new ArrayList<>();
		String sqlLA = "select nota from avaliacoes WHERE id_l = ?";
		PreparedStatement stmtLA = c.prepareStatement(sqlLA, Statement.RETURN_GENERATED_KEYS);
		stmtLA.setInt(1, aval.getIdL());
		ResultSet rsLA = stmtLA.executeQuery();
		if (rsLA.next()) {
			listaNota.add(rsLA.getInt(1));
		}

		int mediaTotal = 0;
		for (int nota : listaNota) {
			mediaTotal += nota;
		}
		mediaTotal = mediaTotal / listaNota.size();
		String sqlL = "UPDATE livros SET media = ?, WHERE id = ?";
		PreparedStatement stmtL = c.prepareStatement(sqlL, Statement.RETURN_GENERATED_KEYS);
		stmtL.setInt(1, mediaTotal);
		stmtL.setInt(2, aval.getIdL());
		
		stmtL.close();
		stmtLA.close();
		
	}

	public Avaliacao buscar(Avaliacao entrada) throws SQLException {
		String sql = "select * from avaliacoes WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, entrada.getId());

		ResultSet rs = stmt.executeQuery();
		Avaliacao saida = null;
		while (rs.next()) {
			saida = new Avaliacao(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
		}
		stmt.close();
		return saida;
	}

	public Avaliacao excluir(Avaliacao livEnt) throws SQLException {
		String sql = "delete from avaliacoes WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, livEnt.getId());
		stmt.execute();
		stmt.close();
		c.close();
		return livEnt;
	}

	public Avaliacao alterar(Avaliacao livEnt) throws SQLException {
		String sql = "UPDATE avaliacoes SET descricao = ?, nota= ? WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, livEnt.getDescricao());
		stmt.setInt(2, livEnt.getNota());
		stmt.setInt(3, livEnt.getId());

		stmt.execute();
		stmt.close();
		return livEnt;
	}

	public List<Avaliacao> listar(Avaliacao entrada) throws SQLException {

		List<Avaliacao> lista = new ArrayList<>();

		String sql = "select * from avaliacoes where descricao like ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + entrada.getDescricao() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Avaliacao avaliacao = new Avaliacao(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			lista.add(avaliacao);
		}

		rs.close();
		stmt.close();
		return lista;
	}
	
	public List<Avaliacao> listarPorLivro(Avaliacao entrada) throws SQLException {

		List<Avaliacao> lista = new ArrayList<>();

		String sql = "select * from avaliacoes where id_l = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, entrada.getIdL());

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Avaliacao avaliacao = new Avaliacao(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			lista.add(avaliacao);
		}

		rs.close();
		stmt.close();
		return lista;
	}
	public List<Avaliacao> listarPorPessoa(Avaliacao entrada) throws SQLException {

		List<Avaliacao> lista = new ArrayList<>();

		String sql = "select * from avaliacoes where id_p = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, entrada.getIdP());

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Avaliacao avaliacao = new Avaliacao(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			lista.add(avaliacao);
		}

		rs.close();
		stmt.close();
		return lista;
	}
}
