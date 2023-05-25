package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerLogradouro;
import backenddm20231n.model.bean.Logradouro;

public class ManterLogradouro {
	
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
    	String cep = JOptionPane.showInputDialog("CEP");
        String num = JOptionPane.showInputDialog("Numero");
        String compl = JOptionPane.showInputDialog("Complemento");
        
        Logradouro entrada = new Logradouro(cep, num, compl);
        ControllerLogradouro contPes = new ControllerLogradouro();
        Logradouro pesSaida = contPes.inserir(entrada);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String cep = JOptionPane.showInputDialog("CEP");
        String num = JOptionPane.showInputDialog("Numero");
        String compl = JOptionPane.showInputDialog("Complemento");
        
        Logradouro pesEnt = new Logradouro(id, cep, num, compl);
        ControllerLogradouro contPes = new ControllerLogradouro();
        Logradouro pesSaida = contPes.alterar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro pesEnt = new Logradouro(id);
        ControllerLogradouro contPes = new ControllerLogradouro();
        Logradouro pesSaida = contPes.buscar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro pesEnt = new Logradouro(id);
        ControllerLogradouro contPes = new ControllerLogradouro();
        Logradouro pesSaida = contPes.excluir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF"));
        Logradouro pesEnt = new Logradouro(cpf);
        
        ControllerLogradouro contPes = new ControllerLogradouro();
        List<Logradouro> listaPessoa = contPes.listar(pesEnt);
        JOptionPane.showMessageDialog(null,listaPessoa);
        
    }

}
