/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.dao.DaoPessoa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerPessoa {

    DaoPessoa daoPes;
    
    public Pessoa inserir(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa();
        Pessoa pesSaida = daoPes.inserir(pesEnt);
        return pesSaida;
    }

    public Pessoa alterar(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa();
        Pessoa pesSaida = daoPes.alterar(pesEnt);
        return pesSaida;
    }

    public Pessoa buscar(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa();
        Pessoa pesSaida = daoPes.buscar(pesEnt);
        return pesSaida;
    }

    public Pessoa excluir(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa();
        Pessoa pesSaida = daoPes.excluir(pesEnt);
        return pesSaida;
        
    }

    public List<Pessoa> listar(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa();
        List<Pessoa> listaPessoa = daoPes.listar(pesEnt);
        return listaPessoa;


    }
    
}
