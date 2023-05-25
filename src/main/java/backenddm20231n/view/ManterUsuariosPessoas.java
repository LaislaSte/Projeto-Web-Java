/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerUsuariosPessoas;
import backenddm20231n.model.bean.UsuariosPessoas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterUsuariosPessoas {
    
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
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuariosPessoas plEnt = new UsuariosPessoas(idU,idP,obs);
        ControllerUsuariosPessoas contPL = new ControllerUsuariosPessoas();
        UsuariosPessoas plSaida = contPL.inserir(plEnt);
        JOptionPane.showMessageDialog(null,plSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuariosPessoas plEnt = new UsuariosPessoas(id,idU,idP,obs);
        ControllerUsuariosPessoas contPL = new ControllerUsuariosPessoas();
        UsuariosPessoas plSaida = contPL.alterar(plEnt);
        JOptionPane.showMessageDialog(null,plSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuariosPessoas plEnt = new UsuariosPessoas(id);
        ControllerUsuariosPessoas contPL = new ControllerUsuariosPessoas();
        UsuariosPessoas plSaida = contPL.buscar(plEnt);
        JOptionPane.showMessageDialog(null,plSaida.toString());
        JOptionPane.showMessageDialog(null,plSaida.getUsu().toString());
        JOptionPane.showMessageDialog(null,plSaida.getPes().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuariosPessoas plEnt = new UsuariosPessoas(id);
        ControllerUsuariosPessoas contPL = new ControllerUsuariosPessoas();
        UsuariosPessoas plSaida = contPL.excluir(plEnt);
        JOptionPane.showMessageDialog(null,plSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        UsuariosPessoas plEnt = new UsuariosPessoas(obs);
        ControllerUsuariosPessoas contPL = new ControllerUsuariosPessoas();
        List<UsuariosPessoas> listaPessoasLogradouros = contPL.listar(plEnt);
        for (UsuariosPessoas plSaida : listaPessoasLogradouros) {
            JOptionPane.showMessageDialog(null,plSaida.toString());
            JOptionPane.showMessageDialog(null,plSaida.getUsu().toString());
           JOptionPane.showMessageDialog(null,plSaida.getPes().toString());
        }
    }

}
