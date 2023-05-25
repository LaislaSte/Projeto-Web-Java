	package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerLivro;
import backenddm20231n.controller.ControllerPedido;
import backenddm20231n.model.bean.Livro;
import backenddm20231n.model.bean.Pedido;

public class ManterPedido {

	public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar \n 6 - Listar por Livro \n 7 - Listar por Pessoa" ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            case 6:
                listarPorLivro();
                break;
            case 7:
                listarPorPessoa();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
    	String busca = JOptionPane.showInputDialog("Busque por Título, Autor, Genero ou Editora");
        Livro livEnt = new Livro(busca);
        ControllerLivro contLiv = new ControllerLivro();
        List<Livro> listaLivro = contLiv.listar(livEnt);
        
    	int idL = Integer.parseInt(JOptionPane.showInputDialog(listaLivro + " \n Insira o ID do livro desejado: "));
    	int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
        int quant = Integer.parseInt(JOptionPane.showInputDialog("Quantidade Desejada"));
        String obs = JOptionPane.showInputDialog("Observação");
        
        Pedido pedEnt = new Pedido(idP, idL, quant, obs);
        ControllerPedido contPed = new ControllerPedido();
        
        Pedido pedSaida = contPed.inserir(pedEnt);
        JOptionPane.showMessageDialog(null,pedSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
    	int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idL = Integer.parseInt(JOptionPane.showInputDialog("ID Livro"));
        int quant = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
        String obs = JOptionPane.showInputDialog("Observação");
        
        Pedido pedEnt = new Pedido(id,0,idL, quant, obs);
        ControllerPedido contPed = new ControllerPedido();
        
        Pedido pedSaida = contPed.alterar(pedEnt);
        JOptionPane.showMessageDialog(null,pedSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
    	int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        Pedido pedEnt = new Pedido(id);
        ControllerPedido contPed = new ControllerPedido();
        
        Pedido pedSaida = contPed.buscar(pedEnt);
        JOptionPane.showMessageDialog(null,pedSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pedido pedEnt = new Pedido(id);
        ControllerPedido contPed = new ControllerPedido();
        Pedido pedSaida = contPed.excluir(pedEnt);
        JOptionPane.showMessageDialog(null,pedSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
    	String obs = JOptionPane.showInputDialog("Observação");
        Pedido pedEnt = new Pedido(obs);
        
        ControllerPedido contPed = new ControllerPedido();
        List<Pedido> listaPedidos = contPed.listar(pedEnt);
        for (Pedido pedSaida : listaPedidos) {
            JOptionPane.showMessageDialog(null,pedSaida.toString());
        }
    }
    private static void listarPorLivro() throws SQLException, ClassNotFoundException {
    	int idL = Integer.parseInt(JOptionPane.showInputDialog("ID do Livro"));
        Pedido entrada = new Pedido(0, 0, idL);  
        ControllerPedido cont = new ControllerPedido();
        List<Pedido> lista = cont.listarPorLivro(entrada);
        
        for (Pedido item : lista) {
            JOptionPane.showMessageDialog(null,item.toString());
        }
    }
    private static void listarPorPessoa() throws SQLException, ClassNotFoundException {
    	int idP = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pedido entrada = new Pedido(0, idP, 0);  
        ControllerPedido cont = new ControllerPedido();
        List<Pedido> lista = cont.listarPorPessoa(entrada);
        
        for (Pedido item : lista) {
            JOptionPane.showMessageDialog(null,item.toString());
        }
    }

}
