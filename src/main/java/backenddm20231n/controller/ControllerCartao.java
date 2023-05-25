package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Cartao;
import backenddm20231n.model.dao.DaoCartao;

public class ControllerCartao {
	
	private DaoCartao daoCartao;
	
	
	public Cartao inserir(Cartao entrada) throws SQLException, ClassNotFoundException{
		daoCartao = new DaoCartao();
		entrada = daoCartao.inserir(entrada);
		return entrada;
	}
	
	public Cartao alterar(Cartao entrada) throws SQLException, ClassNotFoundException {
        daoCartao = new DaoCartao();
        entrada = daoCartao.alterar(entrada);
        return entrada;
    }
    
    public Cartao buscar(Cartao entrada) throws SQLException, ClassNotFoundException {	
        daoCartao = new DaoCartao();
        Cartao avalSaida = daoCartao.buscar(entrada);
        return avalSaida;
    }

    public Cartao excluir(Cartao entrada) throws SQLException, ClassNotFoundException {
        daoCartao = new DaoCartao();
        entrada = daoCartao.excluir(entrada);
        return entrada;
    }
    
    public List<Cartao> listar(Cartao entrada) throws SQLException, ClassNotFoundException {
        daoCartao = new DaoCartao();
        List<Cartao> listaRetorno = daoCartao.listar(entrada);
        return listaRetorno;
    }

}
