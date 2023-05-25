package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Pedido;
import backenddm20231n.util.ConexaoDb;

public class DaoPedido {
	
private final Connection c;
	
	public DaoPedido() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }
	
	public Pedido inserir(Pedido livEnt) throws SQLException{
		
        String sql = "insert into pedidos" + " (id_p, id_l, quantidade, obs)" + " values (?,?,?,?)";
    
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1,livEnt.getIdP());
        stmt.setInt(2,livEnt.getIdL());
        stmt.setInt(3,livEnt.getQuantidade());
        stmt.setString(4, livEnt.getObs());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            livEnt.setId(id);
        }
        stmt.close();
        return livEnt;
    }
	
    
    public Pedido buscar(Pedido entrada) throws SQLException{
        String sql = "select * from pedidos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            
            stmt.setInt(1,entrada.getId());
            
            ResultSet rs = stmt.executeQuery();
            Pedido pesSaida = null;
            while (rs.next()) {
                pesSaida = new Pedido(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5)
                 );
            }
            stmt.close();
        return pesSaida;
   }


   public List<Pedido> listar(Pedido entrada) throws SQLException{
        
        List<Pedido> listaPedidos = new ArrayList<>();
        
        String sql = "select * from pedidos where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setString(1, "%" + entrada.getObs() +"%" );
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Pedido liv = new Pedido(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5)
            );
            listaPedidos.add(liv);
        }
        
        rs.close();
        stmt.close();
        return listaPedidos;
   }
   
   public List<Pedido> listarPorLivro(Pedido entrada) throws SQLException {

		List<Pedido> lista = new ArrayList<>();

		String sql = "select * from pedidos where id_l = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, entrada.getIdL());

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Pedido pedido = new Pedido(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			lista.add(pedido);
		}

		rs.close();
		stmt.close();
		return lista;
	}
	public List<Pedido> listarPorPessoa(Pedido entrada) throws SQLException {

		List<Pedido> lista = new ArrayList<>();

		String sql = "select * from pedidos where id_p = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, entrada.getIdP());

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Pedido pedido = new Pedido(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			lista.add(pedido);
		}

		rs.close();
		stmt.close();
		return lista;
	}
   
   public Pedido alterar(Pedido livEnt) throws SQLException{
       String sql = "UPDATE pedidos SET id_l = ?, quantidade = ?, obs = ? WHERE id = ?";
       PreparedStatement stmt = c.prepareStatement(sql);
       stmt.setInt(1,livEnt.getIdL());
       stmt.setInt(2,livEnt.getQuantidade());
       stmt.setString(3, livEnt.getObs());
       stmt.setInt(4,livEnt.getId());
       
       stmt.execute();
       stmt.close();
       return livEnt;
   }
   
   public Pedido excluir(Pedido livEnt) throws SQLException{
       String sql = "delete from pedidos WHERE id = ?";
       
       PreparedStatement stmt = c.prepareStatement(sql);
       stmt.setInt(1,livEnt.getId());
       stmt.execute();
       stmt.close();
       c.close();
       return livEnt;
   }

}
