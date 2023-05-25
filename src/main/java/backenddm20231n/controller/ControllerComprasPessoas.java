package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Compra;
import backenddm20231n.model.bean.ComprasPessoas;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.dao.DaoComprasPessoas;

public class ControllerComprasPessoas {

	ControllerCompra contComp;
    ControllerPessoa contPes;
    DaoComprasPessoas daoCompPess;
    
    public ComprasPessoas inserir(ComprasPessoas entrada) throws SQLException, ClassNotFoundException {
        daoCompPess = new DaoComprasPessoas();
        entrada = daoCompPess.inserir(entrada);
        return entrada;
    }

    public ComprasPessoas alterar(ComprasPessoas entrada) throws SQLException, ClassNotFoundException {
        daoCompPess = new DaoComprasPessoas();
        entrada = daoCompPess.alterar(entrada);
        return entrada;
    }

    public List<ComprasPessoas> listar(ComprasPessoas entrada) throws SQLException, ClassNotFoundException {
        daoCompPess = new DaoComprasPessoas();
        List<ComprasPessoas> listaCompPesRetornoAux = daoCompPess.listar(entrada);
        List<ComprasPessoas> listaCompPesRetorno = new ArrayList<>();
               
        for(ComprasPessoas comppes : listaCompPesRetornoAux) {        
            listaCompPesRetorno.add(buscar(comppes));
        }

        return listaCompPesRetorno;
    }

    public ComprasPessoas excluir(ComprasPessoas entrada) throws SQLException, ClassNotFoundException {
        daoCompPess = new DaoComprasPessoas();
        entrada = daoCompPess.excluir(entrada);
        return entrada;
    }

    public ComprasPessoas buscar(ComprasPessoas entrada) throws SQLException, ClassNotFoundException {

        daoCompPess = new DaoComprasPessoas();
        ComprasPessoas saida = daoCompPess.buscar(entrada);

        Compra compEnt = new Compra(saida.getIdCom());
        contComp = new ControllerCompra();
        saida.setCompra(contComp.buscar(compEnt));
        
        Pessoa pes = new Pessoa(saida.getIdP());
        contPes = new ControllerPessoa();
        saida.setPessoa(contPes.buscar(pes));

        return saida;
    }


}
