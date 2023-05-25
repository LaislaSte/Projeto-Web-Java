package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerAvaliacao;
import backenddm20231n.controller.ControllerLivro;
import backenddm20231n.model.bean.Avaliacao;
import backenddm20231n.model.bean.Livro;


public class ManterAvaliacao {
      	public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar \n 6 - Listar por Livro \n 7 - Listar por Pessoa";
        
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
            case 6:
                listarPorLivro();
                break;
            case 7:
                listarPorPessoa();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
    	String busca = JOptionPane.showInputDialog("Busque por Título, Autor, Genero ou Editora");
        Livro livEnt = new Livro(busca);
        ControllerLivro contLiv = new ControllerLivro();
        List<Livro> listaLivro = contLiv.listar(livEnt);
    	int idL = Integer.parseInt(JOptionPane.showInputDialog(listaLivro+ " \n Insira o ID do livro desejado: "));
    	int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
        
    	String descricao = JOptionPane.showInputDialog("Descrição");
        int nota = Integer.parseInt(JOptionPane.showInputDialog("nota (0 a 10)"));
        
        Avaliacao entrada = new Avaliacao(idP, idL, descricao, nota);
        ControllerAvaliacao cont = new ControllerAvaliacao();
        Avaliacao saida = cont.inserir(entrada);
        JOptionPane.showMessageDialog(null, saida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String descricao = JOptionPane.showInputDialog("descrição");
        int nota = Integer.parseInt(JOptionPane.showInputDialog("nota"));
        
        Avaliacao entrada = new Avaliacao(id,descricao,nota);
        ControllerAvaliacao cont = new ControllerAvaliacao();
        Avaliacao saida = cont.alterar( entrada);
        JOptionPane.showMessageDialog(null,saida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Avaliacao entrada = new Avaliacao(id);
        ControllerAvaliacao cont = new ControllerAvaliacao();
        Avaliacao saida = cont.buscar(entrada);
        JOptionPane.showMessageDialog(null,saida.toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Avaliacao entrada = new Avaliacao(id);
        ControllerAvaliacao cont = new ControllerAvaliacao();
        Avaliacao saida = cont.excluir(entrada);
        JOptionPane.showMessageDialog(null,saida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String descricao = JOptionPane.showInputDialog("Descrição");
        Avaliacao entrada = new Avaliacao(descricao);  
        ControllerAvaliacao cont = new ControllerAvaliacao();
        List<Avaliacao> lista = cont.listar(entrada);
        
        for (Avaliacao item : lista) {
            JOptionPane.showMessageDialog(null,item.toString());
        }
    }
    
    private static void listarPorLivro() throws SQLException, ClassNotFoundException {
    	int idL = Integer.parseInt(JOptionPane.showInputDialog("ID do Livro"));
        Avaliacao entrada = new Avaliacao(0, 0, idL);  
        ControllerAvaliacao cont = new ControllerAvaliacao();
        List<Avaliacao> lista = cont.listarPorLivro(entrada);
        
        for (Avaliacao item : lista) {
            JOptionPane.showMessageDialog(null,item.toString());
        }
    }
    private static void listarPorPessoa() throws SQLException, ClassNotFoundException {
    	int idP = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Avaliacao entrada = new Avaliacao(0, idP, 0);  
        ControllerAvaliacao cont = new ControllerAvaliacao();
        List<Avaliacao> lista = cont.listarPorPessoa(entrada);
        
        for (Avaliacao item : lista) {
            JOptionPane.showMessageDialog(null,item.toString());
        }
    }
}
