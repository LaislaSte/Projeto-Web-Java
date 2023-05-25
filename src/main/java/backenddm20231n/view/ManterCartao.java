package backenddm20231n.view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerCartao;
import backenddm20231n.model.bean.Cartao;
import backenddm20231n.util.DataHelper;

public class ManterCartao {
	
	 public static void menu() throws SQLException, ClassNotFoundException {
	        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
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
	            default:
	                System.out.println("Opcao inválida");
	        }
	    }

	    private static void inserir() throws SQLException, ClassNotFoundException {
	    	String ns = JOptionPane.showInputDialog("Numero de Série");
	        String banco = JOptionPane.showInputDialog("Banco");
	        String dv = JOptionPane.showInputDialog("Data de Vencimento - Formato: (dd/mm/aaaa)  ");
	        
	        DataHelper dt = new DataHelper(dv);
	        Date dataVen = new Date(dt.getTypeDate().getTime());
	        
	        Cartao entrada = new Cartao(ns, banco,dataVen );
	        ControllerCartao cont = new ControllerCartao();
	        Cartao saida = cont.inserir(entrada);
	        JOptionPane.showMessageDialog(null,saida.toString());
	    }

	    private static void alterar() throws SQLException, ClassNotFoundException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
	        String ns = JOptionPane.showInputDialog("Numero de Serie");
	        String banco = JOptionPane.showInputDialog("Banco");
	        String dv = JOptionPane.showInputDialog("Data de Vencimento - Formato: (dd/mm/aaaa)  ");
	        
	        DataHelper dt = new DataHelper(dv);
	        Date dataVen = new Date(dt.getTypeDate().getTime());
	        
	        Cartao entrada = new Cartao(id, ns, banco,dataVen );
	        ControllerCartao cont = new ControllerCartao();
	        Cartao saida = cont.alterar(entrada);
	        JOptionPane.showMessageDialog(null,saida.toString());
	    }

	    private static void buscar() throws SQLException, ClassNotFoundException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
	        Cartao pesEnt = new Cartao(id);
	        ControllerCartao cont = new ControllerCartao();
	        Cartao pesSaida = cont.buscar(pesEnt);
	        JOptionPane.showMessageDialog(null,pesSaida.toString());
	    }

	    private static void excluir() throws SQLException, ClassNotFoundException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
	        Cartao entrada = new Cartao(id);
	        ControllerCartao cont = new ControllerCartao();
	        Cartao saida = cont.excluir(entrada);
	        JOptionPane.showMessageDialog(null,saida.toString());
	    }

	    private static void listar() throws SQLException, ClassNotFoundException {
	        String banco = JOptionPane.showInputDialog("Banco");
	        Cartao entrada = new Cartao(banco);
	        
	        ControllerCartao cont = new ControllerCartao();
	        List<Cartao> lista = cont.listar(entrada);
	        JOptionPane.showMessageDialog(null,lista);
	    }

}
