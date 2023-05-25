package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Logradouro;
import backenddm20231n.util.ConexaoDb;

public class DaoLogradouro {
private final Connection c;
	
	public DaoLogradouro() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }
	
	public Logradouro inserir(Logradouro livEnt) throws SQLException{
		  
        String sql = "insert into logradouros" + " (cep, numero, compl)" + " values (?,?,?)";
        
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1,livEnt.getCep());
        stmt.setString(2,livEnt.getNumero());
        stmt.setString(3,livEnt.getCompl());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            livEnt.setId(id);
        }
        stmt.close();
        return livEnt;
    }
	
    
    public Logradouro buscar(Logradouro pesEnt) throws SQLException{
        String sql = "select * from logradouros WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1,pesEnt.getId());
            
            ResultSet rs = stmt.executeQuery();
            Logradouro pesSaida = null;
            while (rs.next()) {      
                pesSaida = new Logradouro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                 );
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pesSaida;
   }


   public List<Logradouro> listar(Logradouro livEnt) throws SQLException{
       
        List<Logradouro> listaLivros = new ArrayList<>();
        
        String sql = "select * from logradouros where cep like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%"+livEnt.getCep()+"%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Logradouro liv = new Logradouro(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            listaLivros.add(liv);
        }
        
        rs.close();
        stmt.close();
        return listaLivros;
   }
   
   public Logradouro alterar(Logradouro livEnt) throws SQLException{
       String sql = "UPDATE logradouros SET cep = ?, numero = ?, compl = ? WHERE id = ?";
       
       PreparedStatement stmt = c.prepareStatement(sql);
       stmt.setString(1,livEnt.getCep());
       stmt.setString(2,livEnt.getNumero());
       stmt.setString(3,livEnt.getCompl());
       stmt.setInt(4,livEnt.getId());

       // executa
       stmt.execute();
       stmt.close();
       return livEnt;
   }
   
   public Logradouro excluir(Logradouro livEnt) throws SQLException{
       String sql = "delete from logradouros WHERE id = ?";
       // prepared statement para inserção
       PreparedStatement stmt = c.prepareStatement(sql);
       // seta os valores
       stmt.setInt(1,livEnt.getId());
       // executa
       stmt.execute();
       stmt.close();
       c.close();
       return livEnt;
   }

}
