package backenddm20231n.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import backenddm20231n.model.bean.ComprasPessoas;
import backenddm20231n.util.ConexaoDb;

public class DaoComprasPessoas {

	private final Connection c;

	public DaoComprasPessoas() throws SQLException, ClassNotFoundException {
		this.c = ConexaoDb.getConexaoMySQL();
	}

	public ComprasPessoas excluir(ComprasPessoas entrada) throws SQLException {
		String sql = "delete from compras_pessoas WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, entrada.getId());
		stmt.execute();
		stmt.close();
		c.close();
		return entrada;
	}

	public ComprasPessoas buscar(ComprasPessoas entrada) throws SQLException {
		String sql = "select * from compras_pessoas WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, entrada.getId());
		ResultSet rs = stmt.executeQuery();
		ComprasPessoas saida = null;
		while (rs.next()) {
			saida = new ComprasPessoas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
		}
		stmt.close();
		return saida;
	}

	public ComprasPessoas inserir(ComprasPessoas entrada) throws SQLException {
		String sql = "insert into compras_pessoas" + " (id_p, id_c, obs)" + " values (?,?,?)";
		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setInt(1, entrada.getIdP());
		stmt.setInt(2, entrada.getIdCom());
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

	public ComprasPessoas alterar(ComprasPessoas entrada) throws SQLException {
		String sql = "UPDATE compras_pessoas SET id_p = ?, id_p = ?, obs = ? WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, entrada.getIdP());
		stmt.setInt(2, entrada.getIdCom());
		stmt.setString(3, entrada.getObs());
		stmt.setInt(4, entrada.getId());

		stmt.execute();
		stmt.close();
		return entrada;
	}

	public List<ComprasPessoas> listar(ComprasPessoas entrada) throws SQLException {

		List<ComprasPessoas> listaComprasPess = new ArrayList<>();

		String sql = "select * from compras_pessoas where obs like ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setString(1, "%" + entrada.getObs() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ComprasPessoas CompPess = new ComprasPessoas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			listaComprasPess.add(CompPess);
		}

		rs.close();
		stmt.close();
		return listaComprasPess;

	}

}
