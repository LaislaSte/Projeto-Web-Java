package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import backenddm20231n.model.bean.CartoesPessoas;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.util.ConexaoDb;

public class DaoCartoesPessoas {

	private final Connection c;

	public DaoCartoesPessoas() throws SQLException, ClassNotFoundException {
		this.c = ConexaoDb.getConexaoMySQL();
	}

	public CartoesPessoas excluir(CartoesPessoas entrada) throws SQLException {
		String sql = "delete from cartoes_pessoas WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, entrada.getId());
		stmt.execute();
		stmt.close();
		c.close();
		return entrada;
	}

	public CartoesPessoas buscar(CartoesPessoas entrada) throws SQLException {
		String sql = "select * from cartoes_pessoas WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, entrada.getId());
		ResultSet rs = stmt.executeQuery();
		CartoesPessoas saida = null;
		while (rs.next()) {
			saida = new CartoesPessoas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
		}
		stmt.close();
		return saida;
	}

	public CartoesPessoas inserir(CartoesPessoas entrada) throws SQLException {
		String sql = "insert into cartoes_pessoas" + " (id_p, id_c, obs)" + " values (?,?,?)";
		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setInt(1, entrada.getIdP());
		stmt.setInt(2, entrada.getIdC());
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

	public CartoesPessoas alterar(CartoesPessoas entrada) throws SQLException {
		String sql = "UPDATE cartoes_pessoas SET id_p = ?, id_c = ?, obs = ? WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, entrada.getIdP());
		stmt.setInt(2, entrada.getIdC());
		stmt.setString(3, entrada.getObs());
		stmt.setInt(4, entrada.getId());

		stmt.execute();
		stmt.close();
		return entrada;
	}

	public List<CartoesPessoas> listar(CartoesPessoas entrada) throws SQLException {

		List<CartoesPessoas> listaCartPess = new ArrayList<>();

		String sql = "select * from cartoes_pessoas where obs like ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setString(1, "%" + entrada.getObs() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			CartoesPessoas cartPess = new CartoesPessoas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			listaCartPess.add(cartPess);
		}

		rs.close();
		stmt.close();
		return listaCartPess;

	}

	public List<CartoesPessoas> listarPorPessoa(Pessoa pes) throws SQLException {
		List<CartoesPessoas> listaCartPess = new ArrayList<>();

		String sql = "select * from cartoes_pessoas where id_p = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, pes.getId());

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			CartoesPessoas cartPess = new CartoesPessoas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			listaCartPess.add(cartPess);
		}

		rs.close();
		stmt.close();
		return listaCartPess;
	}

}
