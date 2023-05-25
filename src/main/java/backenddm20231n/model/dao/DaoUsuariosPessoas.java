/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.UsuariosPessoas;
import backenddm20231n.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuariosPessoas {

private final Connection c;
    
    public DaoUsuariosPessoas() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public UsuariosPessoas excluir(UsuariosPessoas usupesEnt) throws SQLException{
        String sql = "delete from usuarios_pessoas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usupesEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usupesEnt;
    }
    
    public UsuariosPessoas buscar(UsuariosPessoas usupesEnt) throws SQLException{
        String sql = "select * from usuarios_pessoas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usupesEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            UsuariosPessoas usupesSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usupesSaida = new UsuariosPessoas(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usupesSaida;
   }

    public UsuariosPessoas inserir(UsuariosPessoas usupesEnt) throws SQLException{
        String sql = "insert into usuarios_pessoas" + " (idU, idP, obs)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,usupesEnt.getIdUsuario());
        stmt.setInt(2,usupesEnt.getIdPessoa());
        stmt.setString(3,usupesEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usupesEnt.setId(id);
        }
        stmt.close();
        return usupesEnt;
    }

    public UsuariosPessoas alterar(UsuariosPessoas usupesEnt) throws SQLException{
        String sql = "UPDATE usuarios_pessoas SET idU = ?, idP = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usupesEnt.getIdUsuario());
        stmt.setInt(2,usupesEnt.getIdPessoa());
        stmt.setString(3,usupesEnt.getObs());
        stmt.setInt(4,usupesEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return usupesEnt;
    }

   public List<UsuariosPessoas> listar(UsuariosPessoas usupesEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<UsuariosPessoas> peslogs = new ArrayList<>();
        
        String sql = "select * from usuarios_pessoas where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usupesEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            UsuariosPessoas peslog = new UsuariosPessoas(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            peslogs.add(peslog);
        }
        
        rs.close();
        stmt.close();
        return peslogs;
   
   }

    
}
