package backenddm20231n.view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerCompra;
import backenddm20231n.controller.ControllerPedido;
import backenddm20231n.model.bean.Compra;
import backenddm20231n.model.bean.Pedido;
import backenddm20231n.util.DataHelper;

public class ManterCompra {

	public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar ";
        
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
                System.out.println("Opção inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
    	
    	String formaPagamento = JOptionPane.showInputDialog("Forma de Pagamento");
        int idP = Integer.parseInt(JOptionPane.showInputDialog(null, "ID Pessoa"));
        
        ControllerPedido cp = new ControllerPedido();
		Pedido p = new Pedido(0, idP, 0);
		
		List<Pedido> listaPedido = cp.listar(p);
		
		double totalCompra = 0.0;
		
		for(Pedido ped : listaPedido) {
			totalCompra += ped.calcularTotalPedido();
		}
       
		java.util.Date data = new java.util.Date();
		Date datasql = new Date(data.getTime());

		Compra entrada = new Compra(formaPagamento, datasql, totalCompra);
        ControllerCompra cont = new ControllerCompra();
        Compra saida = cont.inserir(entrada);
        JOptionPane.showMessageDialog(null, saida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String formaPagamento = JOptionPane.showInputDialog("Forma de Pagamento");
        
        Compra entrada = new Compra(id,formaPagamento);
        ControllerCompra cont = new ControllerCompra();
        Compra saida = cont.alterar(entrada);
        JOptionPane.showMessageDialog(null,saida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Compra entrada = new Compra(id);
        ControllerCompra cont = new ControllerCompra();
        Compra saida = cont.buscar(entrada);
        JOptionPane.showMessageDialog(null,saida.toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Compra entrada = new Compra(id);
        ControllerCompra cont = new ControllerCompra();
        Compra saida = cont.excluir(entrada);
        JOptionPane.showMessageDialog(null,saida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
    	String data = JOptionPane.showInputDialog("Data de Vencimento - Formato: (dd/mm/aaaa)  ");
        
        DataHelper dt = new DataHelper(data);
        Date dataComp = new Date(dt.getTypeDate().getTime());
        
        Compra entrada = new Compra(dataComp);
        ControllerCompra cont = new ControllerCompra();
        
        List<Compra> lista = cont.listar(entrada);
        JOptionPane.showMessageDialog(null,lista);
    }

}
