package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Logradouro;
import backenddm20231n.model.dao.DaoLogradouro;

public class ControllerLogradouro {
private DaoLogradouro daoAval;
	
	public Logradouro inserir(Logradouro avalEnt) throws SQLException, ClassNotFoundException{
		daoAval = new DaoLogradouro();
		avalEnt = daoAval.inserir(avalEnt);
		return avalEnt;
	}
	
	public Logradouro alterar(Logradouro avalEnt) throws SQLException, ClassNotFoundException {
        daoAval = new DaoLogradouro();
        avalEnt = daoAval.alterar(avalEnt);
        return avalEnt;
    }

    public List<Logradouro> listar(Logradouro avalEnt) throws SQLException, ClassNotFoundException {
        daoAval = new DaoLogradouro();
        List<Logradouro> listaAvalRetornoAux = daoAval.listar(avalEnt);
        return listaAvalRetornoAux;
    }
    
    public Logradouro buscar(Logradouro avalEnt) throws SQLException, ClassNotFoundException {
        daoAval = new DaoLogradouro();
        Logradouro avalSaida = daoAval.buscar(avalEnt);
        return avalSaida;
    }

    public Logradouro excluir(Logradouro avalEnt) throws SQLException, ClassNotFoundException {
        daoAval = new DaoLogradouro();
        avalEnt = daoAval.excluir(avalEnt);
        return avalEnt;
    }
}
