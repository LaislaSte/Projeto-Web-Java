package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerLivro;
import backenddm20231n.model.bean.Livro;

public class ManterLivro {
	
	
	public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar \n " ;
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
        String nome = JOptionPane.showInputDialog("Titulo");
        String autor = JOptionPane.showInputDialog("Autor");
        String genero = JOptionPane.showInputDialog("Genero");
        String editora = JOptionPane.showInputDialog("Editora");
        Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do Livro"));
        Livro livroEnt = new Livro(nome,autor, genero, editora, valor);
        ControllerLivro contLiv= new ControllerLivro();
        Livro pesSaida = contLiv.inserir(livroEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Titulo");
        String autor = JOptionPane.showInputDialog("Autor");
        String genero = JOptionPane.showInputDialog("Genero");
        String editora = JOptionPane.showInputDialog("Editora");
        Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
        Livro livEnt = new Livro(id, nome, autor, genero, editora, valor);
        ControllerLivro contLiv = new ControllerLivro();
        Livro pesSaida = contLiv.alterar(livEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Livro pesEnt = new Livro(id);
        ControllerLivro contPes = new ControllerLivro();
        Livro pesSaida = contPes.buscar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
    	int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Livro pesEnt = new Livro(id);
        ControllerLivro contPes = new ControllerLivro();
        Livro pesSaida = contPes.excluir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
    	String busca = JOptionPane.showInputDialog("Busque por Título, Autor, Genero ou Editora");
        Livro pesEnt = new Livro(busca);
        ControllerLivro contPes = new ControllerLivro();
        List<Livro> listaPessoa = contPes.listar(pesEnt);
        JOptionPane.showMessageDialog(null, listaPessoa);
    }

}



