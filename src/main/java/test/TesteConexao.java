package test;


import backenddm20231n.util.ConexaoDb;

/**
 *
 * @author User
 */
public class TesteConexao {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(ConexaoDb.statusConection());
        ConexaoDb.getConexaoMySQL();
        System.out.println(ConexaoDb.statusConection());

    }

    
}
