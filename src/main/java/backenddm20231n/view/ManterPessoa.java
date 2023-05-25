/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerPessoa;
import backenddm20231n.model.bean.Pessoa;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterPessoa {

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
        String nome = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String tipo = JOptionPane.showInputDialog("TIPO");
        String email = JOptionPane.showInputDialog("EMAIL");
        Pessoa pesEnt = new Pessoa(nome,cpf,tipo,email);
        ControllerPessoa contPes = new ControllerPessoa();
        Pessoa pesSaida = contPes.inserir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String tipo = JOptionPane.showInputDialog("TIPO");
        String email = JOptionPane.showInputDialog("EMAIL");
        Pessoa pesEnt = new Pessoa(id,nome,cpf,tipo,email);
        ControllerPessoa contPes = new ControllerPessoa();
        Pessoa pesSaida = contPes.alterar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pesEnt = new Pessoa(id);
        ControllerPessoa contPes = new ControllerPessoa();
        Pessoa pesSaida = contPes.buscar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pesEnt = new Pessoa(id);
        ControllerPessoa contPes = new ControllerPessoa();
        Pessoa pesSaida = contPes.excluir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Pessoa pesEnt = new Pessoa(nome);
        ControllerPessoa contPes = new ControllerPessoa();
        List<Pessoa> listaPessoa = contPes.listar(pesEnt);
        for (Pessoa pesSaida : listaPessoa) {
            JOptionPane.showMessageDialog(null,pesSaida.toString());
        }
    }


    
}
