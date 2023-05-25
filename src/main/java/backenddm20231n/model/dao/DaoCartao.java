package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Cartao;
import backenddm20231n.util.ConexaoDb;

public class DaoCartao {
	private final Connection c;

	public DaoCartao() throws SQLException, ClassNotFoundException {
		this.c = ConexaoDb.getConexaoMySQL();
	}

	public Cartao inserir(Cartao entrada) throws SQLException {
		String sql = "insert into cartoes" + " (numeroSerie, banco, dataVencimento)" + " values (?,?,?)";
		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, entrada.getNumeroSerie());
		stmt.setString(2, entrada.getBanco());
		stmt.setDate(3, entrada.getDataVencimento());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			entrada.setId(id);
		}
		stmt.close();
		return entrada;
	}

	public Cartao buscar(Cartao entrada) throws SQLException {
		String sql = "select * from cartoes WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, entrada.getId());

		ResultSet rs = stmt.executeQuery();
		Cartao saida = null;
		while (rs.next()) {
			saida = new Cartao(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
		}
		stmt.close();
		return saida;
	}

	public Cartao excluir(Cartao livEnt) throws SQLException {
		String sql = "delete from cartoes WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, livEnt.getId());
		stmt.execute();
		stmt.close();
		c.close();
		return livEnt;
	}
	
	public Cartao alterar(Cartao livEnt) throws SQLException {
		String sql = "UPDATE cartoes SET numeroSerie = ?, banco = ?, dataVencimento = ?  WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, livEnt.getNumeroSerie());
		stmt.setString(2, livEnt.getBanco());
		stmt.setDate(3, livEnt.getDataVencimento());
		stmt.setInt(4, livEnt.getId());

		stmt.execute();
		stmt.close();
		return livEnt;
	}
	
	public List<Cartao> listar(Cartao entrada) throws SQLException {

		List<Cartao> lista = new ArrayList<>();

		String sql = "select * from cartoes where banco like ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + entrada.getBanco() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Cartao cartao = new Cartao(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
			lista.add(cartao);
		}

		rs.close();
		stmt.close();
		return lista;
	}
}
