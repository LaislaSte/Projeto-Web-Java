package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Compra;
import backenddm20231n.model.dao.DaoCompra;

public class ControllerCompra {
	
private DaoCompra daoAval;
	
	public Compra inserir(Compra avalEnt) throws SQLException, ClassNotFoundException{
		daoAval = new DaoCompra();
		avalEnt = daoAval.inserir(avalEnt);
		
		return avalEnt;
	}
	
	public Compra alterar(Compra avalEnt) throws SQLException, ClassNotFoundException {
        daoAval = new DaoCompra();
        //altera forma de pagamento
        avalEnt = daoAval.alterar(avalEnt);
        return avalEnt;
    }

    public List<Compra> listar(Compra avalEnt) throws SQLException, ClassNotFoundException {
        daoAval = new DaoCompra();
        //lista por data
        List<Compra> listaRetorno = daoAval.listar(avalEnt);
        return listaRetorno;
    }
    
    public Compra buscar(Compra avalEnt) throws SQLException, ClassNotFoundException {
        daoAval = new DaoCompra();
        Compra avalSaida = daoAval.buscar(avalEnt);
        return avalSaida;
    }

    public Compra excluir(Compra avalEnt) throws SQLException, ClassNotFoundException {
        daoAval = new DaoCompra();
        avalEnt = daoAval.excluir(avalEnt);
        return avalEnt;
    }

}
