package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerLogradourosPessoas;
import backenddm20231n.model.bean.LogradourosPessoas;

public class ManterLogradourosPessoas {

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
		int idL = Integer.parseInt(JOptionPane.showInputDialog("ID Logradouro"));
		int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
		String obs = JOptionPane.showInputDialog("OBS");

		LogradourosPessoas entrada = new LogradourosPessoas(idP, idL, obs);
		ControllerLogradourosPessoas cont = new ControllerLogradourosPessoas();
		LogradourosPessoas saida = cont.inserir(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void alterar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		int idL = Integer.parseInt(JOptionPane.showInputDialog("ID Logradouro"));
		int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
		String obs = JOptionPane.showInputDialog("OBS");
		LogradourosPessoas entrada = new LogradourosPessoas(id, idP, idL, obs);
		ControllerLogradourosPessoas cont = new ControllerLogradourosPessoas();
		LogradourosPessoas saida = cont.alterar(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void buscar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		LogradourosPessoas entrada = new LogradourosPessoas(id);
		ControllerLogradourosPessoas cont = new ControllerLogradourosPessoas();
		LogradourosPessoas saida = cont.buscar(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());

	}

	private static void excluir() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		LogradourosPessoas entrada = new LogradourosPessoas(id);
		ControllerLogradourosPessoas cont = new ControllerLogradourosPessoas();
		LogradourosPessoas saida = cont.excluir(entrada);
		JOptionPane.showMessageDialog(null, saida.toString());
	}

	private static void listar() throws SQLException, ClassNotFoundException {
		String obs = JOptionPane.showInputDialog("OBS");
		LogradourosPessoas entrada = new LogradourosPessoas(obs);
		ControllerLogradourosPessoas cont = new ControllerLogradourosPessoas();
		List<LogradourosPessoas> listaLogrPess = cont.listar(entrada);
		JOptionPane.showMessageDialog(null, listaLogrPess);
		
	}

}
