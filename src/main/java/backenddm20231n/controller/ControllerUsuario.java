/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Usuario;
import backenddm20231n.model.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerUsuario {
    
    DaoUsuario daoUsu;

    public boolean validar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.validar(usuEnt);
        if(usuSaida != null) {
            retorno = true;
        }
        return retorno;
    }
    
    public Usuario validarWeb(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        Usuario retorno = null;
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.validar(usuEnt);
        if(usuSaida != null) {
            retorno = usuSaida;
        }
        return retorno;
    }
    

    public Usuario inserir(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.inserir(usuEnt);
        return usuSaida;
    }

    public Usuario alterar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.alterar(usuEnt);
        return usuSaida;
    }

    public Usuario buscar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.buscar(usuEnt);
        return usuSaida;
    }

    public Usuario excluir(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.excluir(usuEnt);
        return usuSaida;
    }

    public List<Usuario> listar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        List<Usuario> listaUsuario = daoUsu.listar(usuEnt);
        return listaUsuario;
     }
    
}
