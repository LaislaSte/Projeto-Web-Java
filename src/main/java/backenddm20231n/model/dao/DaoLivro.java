package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Livro;
import backenddm20231n.util.ConexaoDb;

public class DaoLivro {

	private final Connection c;

	public DaoLivro() throws SQLException, ClassNotFoundException {
		this.c = ConexaoDb.getConexaoMySQL();
	}

	public Livro inserir(Livro livEnt) throws SQLException {

		String sql = "insert into livros" + " (titulo, autor, genero, editora, valor)" + " values (?,?,?,?,?)";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, livEnt.getTitulo());
		stmt.setString(2, livEnt.getAutor());
		stmt.setString(3, livEnt.getGenero());
		stmt.setString(4, livEnt.getEditora());
		stmt.setDouble(5, livEnt.getValor());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			livEnt.setId(id);
		}
		stmt.close();
		return livEnt;
	}

	public Livro buscar(Livro pesEnt) throws SQLException {
		String sql = "select * from livros WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, pesEnt.getId());
		ResultSet rs = stmt.executeQuery();
		Livro pesSaida = null;
		while (rs.next()) {
			pesSaida = new Livro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDouble(6));
		}
		stmt.close();
		return pesSaida;
	}

	public List<Livro> listar(Livro livEnt) throws SQLException {

		List<Livro> listaLivros = new ArrayList<>();

		String sql = "select * from livros where autor like ? OR titulo like ? OR genero like ? OR editora like ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + livEnt.getAutor() + "%");
		stmt.setString(2, "%" + livEnt.getAutor() + "%");
		stmt.setString(3, "%" + livEnt.getAutor() + "%");
		stmt.setString(4, "%" + livEnt.getAutor() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) { 
			Livro liv = new Livro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDouble(6));

			listaLivros.add(liv);
		}

		rs.close();
		stmt.close();
		return listaLivros;
	}

	public Livro alterar(Livro livEnt) throws SQLException {
		String sql = "UPDATE livros SET titulo = ?, autor = ?, genero = ?, editora = ?, valor = ? WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		
		stmt.setString(1, livEnt.getTitulo());
		stmt.setString(2, livEnt.getAutor());
		stmt.setString(3, livEnt.getGenero());
		stmt.setString(4, livEnt.getEditora());
		stmt.setDouble(5, livEnt.getValor());
		stmt.setInt(6, livEnt.getId());

		stmt.execute();
		stmt.close();
		return livEnt;
	}

	public Livro excluir(Livro livEnt) throws SQLException {
		String sql = "delete from livros WHERE id = ?";
		
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, livEnt.getId());
		stmt.execute();
		
		stmt.close();
		c.close();
		return livEnt;
	}

}
