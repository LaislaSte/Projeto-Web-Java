package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Avaliacao;
import backenddm20231n.model.bean.Livro;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.dao.DaoAvaliacao;

public class ControllerAvaliacao {
private DaoAvaliacao daoAvalicao;
	
	
	public Avaliacao inserir(Avaliacao entrada) throws SQLException, ClassNotFoundException{
		daoAvalicao = new DaoAvaliacao();
		entrada = daoAvalicao.inserir(entrada);
		return entrada;
	}
	
	public Avaliacao alterar(Avaliacao entrada) throws SQLException, ClassNotFoundException {
        daoAvalicao = new DaoAvaliacao();
        entrada = daoAvalicao.alterar(entrada);
        return entrada;
    }
    
    public Avaliacao buscar(Avaliacao entrada) throws SQLException, ClassNotFoundException {	
        daoAvalicao = new DaoAvaliacao();
        Avaliacao avalSaida = daoAvalicao.buscar(entrada);
        ControllerPessoa cp = new ControllerPessoa();
        ControllerLivro cl = new ControllerLivro();
        
        avalSaida.setLivro(cl.buscar(new Livro(avalSaida.getIdL()) ));
        avalSaida.setPessoa(cp.buscar(new Pessoa(avalSaida.getIdP()) ));
        
        return avalSaida;
    }

    public Avaliacao excluir(Avaliacao entrada) throws SQLException, ClassNotFoundException {
        daoAvalicao = new DaoAvaliacao();
        entrada = daoAvalicao.excluir(entrada);
        return entrada;
    }
    
    public List<Avaliacao> listar(Avaliacao entrada) throws SQLException, ClassNotFoundException {
        daoAvalicao = new DaoAvaliacao();
        List<Avaliacao> listaRetorno = daoAvalicao.listar(entrada);
        ControllerPessoa cp = new ControllerPessoa();
        ControllerLivro cl = new ControllerLivro();
        
        for(Avaliacao aval : listaRetorno) {
        	aval.setLivro(cl.buscar(new Livro(aval.getIdL()) ));
        	aval.setPessoa(cp.buscar(new Pessoa(aval.getIdP()) ));
        }
        
        return listaRetorno;
    }
    
    public List<Avaliacao> listarPorLivro(Avaliacao entrada) throws SQLException, ClassNotFoundException {
        daoAvalicao = new DaoAvaliacao();
        List<Avaliacao> listaRetorno = daoAvalicao.listarPorLivro(entrada);
        ControllerPessoa cp = new ControllerPessoa();
        for(Avaliacao aval : listaRetorno) {
        	aval.setPessoa(cp.buscar(new Pessoa(aval.getIdP()) ));
        }
        return listaRetorno;
    }
    
    public List<Avaliacao> listarPorPessoa(Avaliacao entrada) throws SQLException, ClassNotFoundException {
        daoAvalicao = new DaoAvaliacao();
        List<Avaliacao> listaRetorno = daoAvalicao.listarPorPessoa(entrada);
        ControllerLivro cl = new ControllerLivro();
        for(Avaliacao aval : listaRetorno) {
        	aval.setLivro(cl.buscar(new Livro(aval.getIdL()) ));
        }
        return listaRetorno;
    }

    
}
