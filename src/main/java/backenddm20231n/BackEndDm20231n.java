/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n;

import backenddm20231n.view.ManterAvaliacao;
import backenddm20231n.view.ManterCartao;
import backenddm20231n.view.ManterCartoesPessoas;
import backenddm20231n.view.ManterCompra;
import backenddm20231n.view.ManterComprasPessoas;
import backenddm20231n.view.ManterLivro;
import backenddm20231n.view.ManterLogradouro;
import backenddm20231n.view.ManterLogradourosPessoas;
import backenddm20231n.view.ManterPedido;
import backenddm20231n.view.ManterPessoa;
import backenddm20231n.view.ManterUsuario;
import backenddm20231n.view.ManterUsuariosPessoas;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BackEndDm20231n {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		if (ManterUsuario.validar()) {
			menu();
		} else {
			JOptionPane.showMessageDialog(null, "Usuario Inválido");
		}
	}

	public static String callOption() {
		String msg = " 0 - Sair \n 1 - Usuario \n 2 - Pessoa \n 3 - UsuariosPessoas \n 4 - Livro \n 5 - Avaliacao \n 6 - Pedido \n "
				+ "7 - Cartao \n 8 - CartoesPessoas \n 9 - Logradouro \n 10 - LogradourosPessoas \n 11 - Compra \n 12 - ComprasPessoas ";
		return msg;
	}

	public static void menu() throws SQLException, ClassNotFoundException {
		// String msg = " 0 - Sair \n 1 - Usuario \n 2 - Pessoa \n 3 - UsuariosPessoas
		// \n 4 - Livro \n 5 - Avaliacao \n 6 - Pedido \n "
		// + "7 - Cartao \n 8 - CartoesPessoas \n 9 - Logradouro \n 10 -
		// LogradourosPessoas \n 11 - Compra \n 12 - ComprasPessoas ";
		
		int num = Integer.parseInt(JOptionPane.showInputDialog(callOption()));
		while (num != 0) {
			switch (num) {
			case 0:
				int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
				if (sair > 0)
					menu();
				break;
			case 1:
				ManterUsuario.menu();
				break;
			case 2:
				ManterPessoa.menu();
				break;
			case 3:
				ManterUsuariosPessoas.menu();
				break;
			case 4:
				ManterLivro.menu();
				break;
			case 5:
				ManterAvaliacao.menu();
				break;
			case 6:
				ManterPedido.menu();
				break;
			case 7:
				ManterCartao.menu();
				break;
			case 8:
				ManterCartoesPessoas.menu();
				break;
			case 9:
				ManterLogradouro.menu();
				break;
			case 10:
				ManterLogradourosPessoas.menu();
				break;
			case 11:
				ManterCompra.menu();
				break;
			case 12:
				ManterComprasPessoas.menu();
				break;
			default:
				System.out.println("Opção inválido");
			}
			
			num = Integer.parseInt(JOptionPane.showInputDialog(callOption()));
		}
	}

}
