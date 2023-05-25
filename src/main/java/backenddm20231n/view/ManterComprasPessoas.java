package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerComprasPessoas;
import backenddm20231n.model.bean.ComprasPessoas;

public class ManterComprasPessoas {

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
		int idComp = Integer.parseInt(JOptionPane.showInputDialog("ID Compra"));
		int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
		String obs = JOptionPane.showInputDialog("OBS");

		ComprasPessoas entrada = new ComprasPessoas(idP, idComp, obs);
		ControllerComprasPessoas cont = new ControllerComprasPessoas();
		ComprasPessoas saida = cont.inserir(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void alterar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		int idComp = Integer.parseInt(JOptionPane.showInputDialog("ID Compra"));
		int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
		String obs = JOptionPane.showInputDialog("OBS");
		ComprasPessoas entrada = new ComprasPessoas(id, idP, idComp, obs);
		ControllerComprasPessoas cont = new ControllerComprasPessoas();
		ComprasPessoas saida = cont.alterar(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void buscar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		ComprasPessoas entrada = new ComprasPessoas(id);
		ControllerComprasPessoas cont = new ControllerComprasPessoas();
		ComprasPessoas saida = cont.buscar(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());

	}

	private static void excluir() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		ComprasPessoas entrada = new ComprasPessoas(id);
		ControllerComprasPessoas cont = new ControllerComprasPessoas();
		ComprasPessoas saida = cont.excluir(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void listar() throws SQLException, ClassNotFoundException {
		String obs = JOptionPane.showInputDialog("OBS");
		ComprasPessoas entrada = new ComprasPessoas(obs);
		ControllerComprasPessoas cont = new ControllerComprasPessoas();
		List<ComprasPessoas> listaCompPess = cont.listar(entrada);
		JOptionPane.showMessageDialog(null,listaCompPess);
	}

}
