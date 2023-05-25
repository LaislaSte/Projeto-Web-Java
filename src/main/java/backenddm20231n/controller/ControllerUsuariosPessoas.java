/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Usuario;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.bean.UsuariosPessoas;
import backenddm20231n.model.dao.DaoUsuariosPessoas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lab04aluno
 */
public class ControllerUsuariosPessoas {
    
    ControllerUsuario contUsu;
    ControllerPessoa contPes;
    DaoUsuariosPessoas daoUsuPes;
    
    public UsuariosPessoas inserir(UsuariosPessoas usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuariosPessoas();
        usupesEnt = daoUsuPes.inserir(usupesEnt);
        return usupesEnt;
    }

    public UsuariosPessoas alterar(UsuariosPessoas usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuariosPessoas();
        usupesEnt = daoUsuPes.alterar(usupesEnt);
        return usupesEnt;
    }

    public List<UsuariosPessoas> listar(UsuariosPessoas usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuariosPessoas();
        List<UsuariosPessoas> listaUsuPesRetornoAux = daoUsuPes.listar(usupesEnt);
        List<UsuariosPessoas> listaUsuPesRetorno = new ArrayList<>();
               
        for(UsuariosPessoas usupes : listaUsuPesRetornoAux) {        
            listaUsuPesRetorno.add(buscar(usupes));
        }

        return listaUsuPesRetorno;
    }

    public UsuariosPessoas excluir(UsuariosPessoas usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuariosPessoas();
        usupesEnt = daoUsuPes.excluir(usupesEnt);
        return usupesEnt;
    }

    public UsuariosPessoas buscar(UsuariosPessoas usupesEnt) throws SQLException, ClassNotFoundException {

        daoUsuPes = new DaoUsuariosPessoas();
        UsuariosPessoas usupesSaida = daoUsuPes.buscar(usupesEnt);

        Usuario usuEnt = new Usuario(usupesSaida.getIdUsuario());
        contUsu = new ControllerUsuario();
        usupesSaida.setUsu(contUsu.buscar(usuEnt));
        
        Pessoa pes = new Pessoa(usupesSaida.getIdPessoa());
        contPes = new ControllerPessoa();
        usupesSaida.setPes(contPes.buscar(pes));

        return usupesSaida;
    }


    
}
