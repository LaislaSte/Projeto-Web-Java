package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Logradouro;
import backenddm20231n.model.bean.LogradourosPessoas;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.dao.DaoLogradourosPessoas;

public class ControllerLogradourosPessoas {

	ControllerLogradouro contLogr;
    ControllerPessoa contPes;
    DaoLogradourosPessoas daoLogrPess;
    
    public LogradourosPessoas inserir(LogradourosPessoas entrada) throws SQLException, ClassNotFoundException {
        daoLogrPess = new DaoLogradourosPessoas();
        entrada = daoLogrPess.inserir(entrada);
        return entrada;
    }

    public LogradourosPessoas alterar(LogradourosPessoas entrada) throws SQLException, ClassNotFoundException {
        daoLogrPess = new DaoLogradourosPessoas();
        entrada = daoLogrPess.alterar(entrada);
        return entrada;
    }

    public List<LogradourosPessoas> listar(LogradourosPessoas entrada) throws SQLException, ClassNotFoundException {
        daoLogrPess = new DaoLogradourosPessoas();
        List<LogradourosPessoas> listaLogrPesRetornoAux = daoLogrPess.listar(entrada);
        List<LogradourosPessoas> listaLogrPesRetorno = new ArrayList<>();
               
        for(LogradourosPessoas logrpes : listaLogrPesRetornoAux) {        
            listaLogrPesRetorno.add(buscar(logrpes));
        }

        return listaLogrPesRetorno;
    }

    public LogradourosPessoas excluir(LogradourosPessoas entrada) throws SQLException, ClassNotFoundException {
        daoLogrPess = new DaoLogradourosPessoas();
        entrada = daoLogrPess.excluir(entrada);
        return entrada;
    }

    public LogradourosPessoas buscar(LogradourosPessoas entrada) throws SQLException, ClassNotFoundException {

        daoLogrPess = new DaoLogradourosPessoas();
        LogradourosPessoas saida = daoLogrPess.buscar(entrada);

        Logradouro logrEnt = new Logradouro(saida.getIdL());
        contLogr = new ControllerLogradouro();
        saida.setLogradouro(contLogr.buscar(logrEnt));
        
        Pessoa pes = new Pessoa(saida.getIdP());
        contPes = new ControllerPessoa();
        saida.setPessoa(contPes.buscar(pes));

        return saida;
    }
    
    public List<LogradourosPessoas> listarPorPessoa(Pessoa pes) throws SQLException, ClassNotFoundException {
    	daoLogrPess = new DaoLogradourosPessoas();
    	List<LogradourosPessoas> listaLogrPesRetornoAux = daoLogrPess.listarPorPessoa(pes);
    	contLogr = new ControllerLogradouro();
    	contPes = new ControllerPessoa();
    	Pessoa pess = pes;
    	Logradouro logr = new Logradouro(123);

    	for(LogradourosPessoas lp : listaLogrPesRetornoAux) {
    		logr.setId(lp.getId());
    		pess.setId(lp.getId());
    		lp.setLogradouro(contLogr.buscar(logr));
    		lp.setPessoa(contPes.buscar(pess));
    	}
    	
    	return listaLogrPesRetornoAux;
    }


}
