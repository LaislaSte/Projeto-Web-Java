package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Livro;
import backenddm20231n.model.dao.DaoLivro;


public class ControllerLivro {
	private DaoLivro daoLiv;
	
	public Livro inserir(Livro livEnt) throws SQLException, ClassNotFoundException {
        daoLiv = new DaoLivro();
        Livro livSaida = daoLiv.inserir(livEnt);
        return livSaida;
    }

    public Livro alterar(Livro livEnt) throws SQLException, ClassNotFoundException {
        daoLiv = new DaoLivro();
        Livro livSaida = daoLiv.alterar(livEnt);
        return livSaida;
    }

    public Livro buscar(Livro livEnt) throws SQLException, ClassNotFoundException {
        daoLiv = new DaoLivro();
        Livro livSaida = daoLiv.buscar(livEnt);
        return livSaida;
        
    }

    public Livro excluir(Livro livEnt) throws SQLException, ClassNotFoundException {
        daoLiv = new DaoLivro();
        Livro livSaida = daoLiv.excluir(livEnt);
        return livSaida;
    }

    public List<Livro> listar(Livro livEnt) throws SQLException, ClassNotFoundException {
        daoLiv = new DaoLivro();
        List<Livro> listaLivro = daoLiv.listar(livEnt);
        return listaLivro;
    }

}
