package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.LogradourosPessoas;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.util.ConexaoDb;

public class DaoLogradourosPessoas {

	private final Connection c;

	public DaoLogradourosPessoas() throws SQLException, ClassNotFoundException {
		this.c = ConexaoDb.getConexaoMySQL();
	}

	public LogradourosPessoas excluir(LogradourosPessoas entrada) throws SQLException {
		String sql = "delete from logradouros_pessoas WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, entrada.getId());
		stmt.execute();
		stmt.close();
		c.close();
		return entrada;
	}

	public LogradourosPessoas buscar(LogradourosPessoas entrada) throws SQLException {
		String sql = "select * from logradouros_pessoas WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, entrada.getId());
		ResultSet rs = stmt.executeQuery();
		LogradourosPessoas saida = null;
		while (rs.next()) {
			saida = new LogradourosPessoas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
		}
		stmt.close();
		return saida;
	}

	public LogradourosPessoas inserir(LogradourosPessoas entrada) throws SQLException {
		String sql = "insert into logradouros_pessoas" + " (id_p, id_l, obs)" + " values (?,?,?)";
		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setInt(1, entrada.getIdP());
		stmt.setInt(2, entrada.getIdL());
		stmt.setString(3, entrada.getObs());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			entrada.setId(id);
		}
		stmt.close();
		return entrada;
	}

	public LogradourosPessoas alterar(LogradourosPessoas entrada) throws SQLException {
		String sql = "UPDATE logradouros_pessoas SET id_p = ?, id_p = ?, obs = ? WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, entrada.getIdP());
		stmt.setInt(2, entrada.getIdL());
		stmt.setString(3, entrada.getObs());
		stmt.setInt(4, entrada.getId());

		stmt.execute();
		stmt.close();
		return entrada;
	}

	public List<LogradourosPessoas> listar(LogradourosPessoas entrada) throws SQLException {

		List<LogradourosPessoas> listaLogrPess = new ArrayList<>();

		String sql = "select * from logradouros_pessoas where obs like ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setString(1, "%" + entrada.getObs() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			LogradourosPessoas logrPess = new LogradourosPessoas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			listaLogrPess.add(logrPess);
		}

		rs.close();
		stmt.close();
		return listaLogrPess;

	}

	public List<LogradourosPessoas> listarPorPessoa(Pessoa pes) throws SQLException {
		List<LogradourosPessoas> listaLogrPess = new ArrayList<>();

		String sql = "select * from logradouros_pessoas where id_p = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, pes.getId());

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			LogradourosPessoas logrPess = new LogradourosPessoas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			listaLogrPess.add(logrPess);
		}

		rs.close();
		stmt.close();
		return listaLogrPess;
	}

}
