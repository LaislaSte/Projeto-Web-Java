package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Livro;
import backenddm20231n.model.bean.Pedido;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.dao.DaoPedido;

public class ControllerPedido {
private DaoPedido daoPedido;
	
	public Pedido inserir(Pedido entrada) throws SQLException, ClassNotFoundException {
        daoPedido = new DaoPedido();
        Pedido pedidoSaida = daoPedido.inserir(entrada);
        
        ControllerPessoa cp = new ControllerPessoa();
        Pessoa p = new Pessoa(pedidoSaida.getIdP());
        
        ControllerLivro cl = new ControllerLivro();
        Livro l = new Livro(pedidoSaida.getIdL());
        
        pedidoSaida.setPessoa(cp.buscar(p));
        pedidoSaida.setLivro(cl.buscar(l));
        
        return pedidoSaida;
    }

    public Pedido alterar(Pedido entrada) throws SQLException, ClassNotFoundException {
        daoPedido = new DaoPedido();
        Pedido pedidoSaida = daoPedido.alterar(entrada);
        return pedidoSaida;
    }

    public Pedido buscar(Pedido entrada) throws SQLException, ClassNotFoundException {
        daoPedido = new DaoPedido();
        Pedido pedidoSaida = daoPedido.buscar(entrada);
        
        ControllerPessoa cp = new ControllerPessoa();
        Pessoa p = new Pessoa(pedidoSaida.getIdP());
        
        ControllerLivro cl = new ControllerLivro();
        Livro l = new Livro(pedidoSaida.getIdL());
        
        pedidoSaida.setPessoa(cp.buscar(p));
        pedidoSaida.setLivro(cl.buscar(l));
        
        return pedidoSaida;
    }

    public Pedido excluir(Pedido entrada) throws SQLException, ClassNotFoundException {
        daoPedido = new DaoPedido();
        Pedido pedidoSaida = daoPedido.excluir(entrada);
        return pedidoSaida;
    }

    public List<Pedido> listar(Pedido entrada) throws SQLException, ClassNotFoundException {
        daoPedido = new DaoPedido();
        List<Pedido> listaPedido = daoPedido.listar(entrada);
        
        ControllerPessoa cp = new ControllerPessoa();
        ControllerLivro cl = new ControllerLivro();
        for(Pedido ped : listaPedido) {
            ped.setPessoa(cp.buscar(new Pessoa(ped.getIdP())));
            ped.setLivro(cl.buscar(new Livro(ped.getIdL())));
        }
        
        return listaPedido;

    }
    
    public List<Pedido> listarPorLivro(Pedido entrada) throws SQLException, ClassNotFoundException {
        daoPedido = new DaoPedido();
        List<Pedido> listaRetorno = daoPedido.listarPorLivro(entrada);
        ControllerPessoa cp = new ControllerPessoa();
        for(Pedido ped : listaRetorno) {
        	ped.setPessoa(cp.buscar(new Pessoa(ped.getIdP()) ));
        }
        return listaRetorno;
    }
    
    public List<Pedido> listarPorPessoa(Pedido entrada) throws SQLException, ClassNotFoundException {
        daoPedido = new DaoPedido();
        List<Pedido> listaRetorno = daoPedido.listarPorPessoa(entrada);
        ControllerLivro cl = new ControllerLivro();
        for(Pedido ped : listaRetorno) {
        	ped.setLivro(cl.buscar(new Livro(ped.getIdL()) ));
        }
        return listaRetorno;
    }
}






