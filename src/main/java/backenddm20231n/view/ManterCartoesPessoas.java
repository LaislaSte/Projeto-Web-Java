package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerCartoesPessoas;
import backenddm20231n.model.bean.CartoesPessoas;

public class ManterCartoesPessoas {

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
		int idC = Integer.parseInt(JOptionPane.showInputDialog("ID Cartão"));
		int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
		String obs = JOptionPane.showInputDialog("OBS");

		CartoesPessoas entrada = new CartoesPessoas(idP, idC, obs);
		ControllerCartoesPessoas cont = new ControllerCartoesPessoas();
		CartoesPessoas saida = cont.inserir(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void alterar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		int idC = Integer.parseInt(JOptionPane.showInputDialog("ID Cartão"));
		int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
		String obs = JOptionPane.showInputDialog("OBS");
		CartoesPessoas entrada = new CartoesPessoas(id, idP, idC, obs);
		ControllerCartoesPessoas cont = new ControllerCartoesPessoas();
		CartoesPessoas saida = cont.alterar(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void buscar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		CartoesPessoas entrada = new CartoesPessoas(id);
		ControllerCartoesPessoas cont = new ControllerCartoesPessoas();
		CartoesPessoas saida = cont.buscar(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());

	}

	private static void excluir() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		CartoesPessoas entrada = new CartoesPessoas(id);
		ControllerCartoesPessoas cont = new ControllerCartoesPessoas();
		CartoesPessoas saida = cont.excluir(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void listar() throws SQLException, ClassNotFoundException {
		String obs = JOptionPane.showInputDialog("OBS");
		CartoesPessoas entrada = new CartoesPessoas(obs);
		ControllerCartoesPessoas cont = new ControllerCartoesPessoas();
		List<CartoesPessoas> listaCartPess = cont.listar(entrada);
		JOptionPane.showMessageDialog(null, listaCartPess);
	}

}
