package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Compra;
import backenddm20231n.util.ConexaoDb;

public class DaoCompra {
private final Connection c;
	
	public DaoCompra() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }
	
	public Compra inserir(Compra livEnt) throws SQLException{
		
		String sql = "insert into compras" + " (formaPagamento, data, total)" + " values (?,?,?)";
        
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1,livEnt.getFormaPagamento());
        stmt.setDate(2,livEnt.getData());
        stmt.setDouble(3, livEnt.getTotal());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            livEnt.setId(id);
        }
        stmt.close();
        return livEnt;
    }
	
    
    public Compra buscar(Compra pesEnt) throws SQLException{
        String sql = "select * from compras WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
           
            stmt.setInt(1,pesEnt.getId());
            ResultSet rs = stmt.executeQuery();
            Compra pesSaida = null;
            while (rs.next()) {      
                pesSaida = new Compra(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDate(3),
                    rs.getDouble(4)
                 );
            }
            stmt.close();
        return pesSaida;
   }


   public List<Compra> listar(Compra livEnt) throws SQLException{
        
        List<Compra> listaLivros = new ArrayList<>();
        
        String sql = "select * from compras where data = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setDate(1,livEnt.getData());
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Compra liv = new Compra(
                rs.getInt(1),
                rs.getString(2),
                rs.getDate(3),
                rs.getDouble(4)
            );
            listaLivros.add(liv);
        }
        
        rs.close();
        stmt.close();
        return listaLivros;
   }
   
   public Compra alterar(Compra livEnt) throws SQLException{
	   String sql = "UPDATE compras SET formaPagamento = ? WHERE id = ?";
       PreparedStatement stmt = c.prepareStatement(sql);
       stmt.setString(1,livEnt.getFormaPagamento());
       stmt.setInt(2,livEnt.getId());

       stmt.execute();
       stmt.close();
       return livEnt;
   }
   
   public Compra excluir(Compra livEnt) throws SQLException{
       String sql = "delete from compras WHERE id = ?";
       PreparedStatement stmt = c.prepareStatement(sql);
       stmt.setInt(1,livEnt.getId());
       stmt.execute();
       stmt.close();
       c.close();
       return livEnt;
   }
}
