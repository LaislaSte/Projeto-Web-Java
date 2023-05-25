package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Cartao;
import backenddm20231n.model.bean.CartoesPessoas;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.dao.DaoCartoesPessoas;

public class ControllerCartoesPessoas {

	ControllerCartao contCart;
    ControllerPessoa contPes;
    DaoCartoesPessoas daoCartPess;
    
    public CartoesPessoas inserir(CartoesPessoas entrada) throws SQLException, ClassNotFoundException {
        daoCartPess = new DaoCartoesPessoas();
        entrada = daoCartPess.inserir(entrada);
        return entrada;
    }

    public CartoesPessoas alterar(CartoesPessoas entrada) throws SQLException, ClassNotFoundException {
        daoCartPess = new DaoCartoesPessoas();
        entrada = daoCartPess.alterar(entrada);
        return entrada;
    }

    public List<CartoesPessoas> listar(CartoesPessoas entrada) throws SQLException, ClassNotFoundException {
        daoCartPess = new DaoCartoesPessoas();
        List<CartoesPessoas> listaCartPesRetorno = daoCartPess.listar(entrada);
        contCart = new ControllerCartao();
        contPes = new ControllerPessoa();

        for(CartoesPessoas cartpes : listaCartPesRetorno) {        
        	cartpes.setCartao(contCart.buscar(new Cartao(cartpes.getIdC())));
        	cartpes.setPessoa(contPes.buscar(new Pessoa(cartpes.getIdP())));
        }

        return listaCartPesRetorno;
    }

    public CartoesPessoas excluir(CartoesPessoas entrada) throws SQLException, ClassNotFoundException {
        daoCartPess = new DaoCartoesPessoas();
        entrada = daoCartPess.excluir(entrada);
        return entrada;
    }

    public CartoesPessoas buscar(CartoesPessoas entrada) throws SQLException, ClassNotFoundException {

        daoCartPess = new DaoCartoesPessoas();
        CartoesPessoas saida = daoCartPess.buscar(entrada);
;
        contCart = new ControllerCartao();
        saida.setCartao(contCart.buscar(new Cartao(saida.getIdC())));
        
        contPes = new ControllerPessoa();
        saida.setPessoa(contPes.buscar(new Pessoa(saida.getIdP())));

        return saida;
    }
    
    public List<CartoesPessoas> listarPorPessoa(Pessoa pes) throws SQLException, ClassNotFoundException{
    	daoCartPess = new DaoCartoesPessoas();
    	List<CartoesPessoas> listaCartPesRetornoAux = daoCartPess.listarPorPessoa(pes);
    	contCart = new ControllerCartao();
    	contPes = new ControllerPessoa();
    	Pessoa pess = pes;
    	Cartao cart = new Cartao(123);

    	for(CartoesPessoas cp : listaCartPesRetornoAux) {
    		cart.setId(cp.getId());
    		pess.setId(cp.getId());
    		cp.setCartao(contCart.buscar(cart));
    		cp.setPessoa(contPes.buscar(pess));
    	}
    	
    	return listaCartPesRetornoAux;
    	
    }

}
