<%@page import="backenddm20231n.model.bean.ComprasPessoas"%>
<%@page import="backenddm20231n.model.bean.CartoesPessoas"%>
<%@page import="backenddm20231n.model.bean.LogradourosPessoas"%>
<%@page import="backenddm20231n.model.bean.Cartao"%>
<%@page import="backenddm20231n.model.bean.Logradouro"%>
<%@page import="backenddm20231n.controller.ControllerComprasPessoas"%>
<%@page import="backenddm20231n.controller.ControllerLogradourosPessoas"%>
<%@page import="backenddm20231n.controller.ControllerLogradouro"%>
<%@page import="backenddm20231n.controller.ControllerCartoesPessoas"%>
<%@page import="backenddm20231n.controller.ControllerCartao"%>
<%@page import="java.util.List"%>
<%@page import="backenddm20231n.controller.ControllerPedido"%>
<%@page import="backenddm20231n.model.bean.Pedido"%>
<%@page import="java.sql.Date"%>
<%@page import="backenddm20231n.controller.ControllerCompra"%>
<%@page import="backenddm20231n.model.bean.Compra"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

String formaPagamento = request.getParameter("FORMA_PAGAMENTO");
int idP = Integer.parseInt(request.getParameter("ID_PES"));
String nomeP = request.getParameter("NOME_PESSOA");

int idL = 0;
if(request.getParameter("ID_LOG") != null){
	idL = Integer.parseInt(request.getParameter("ID_LOG"));	
}
int idC=0;
if(request.getParameter("ID_CAR") != null){
	idC = Integer.parseInt(request.getParameter("ID_CAR"));
}

String cep = request.getParameter("CEP");
String endereco = request.getParameter("ENDERECO");
String comp = request.getParameter("COMP");

String numSerie = request.getParameter("NUM_SERIE");
String banco = request.getParameter("BANCO");
String dataVencimento = request.getParameter("DATA_VENCIMENTO");

ControllerPedido cp = new ControllerPedido();
Pedido p = new Pedido(0, idP, 0);
List<Pedido> listaPedido = cp.listar(p);
double totalCompra = 0.0;
for(Pedido ped : listaPedido) {
	totalCompra += ped.calcularTotalPedido();
}

java.util.Date data = new java.util.Date();
Date datasql = new Date(data.getTime());

Compra entrada = new Compra(formaPagamento, datasql, totalCompra);
ControllerCompra cont = new ControllerCompra();
Compra compra = cont.inserir(entrada);

Cartao cartao = null;
ControllerCartao contcar = new ControllerCartao();
ControllerCartoesPessoas contcarpes = new ControllerCartoesPessoas();
String msgCP = "Cartao de "+nomeP ;
if(idC != 0){
	contcarpes.inserir(new CartoesPessoas(idP, idC, msgCP));
}else{
	cartao = contcar.inserir(new Cartao(numSerie, banco, Date.valueOf(dataVencimento)));
	contcarpes.inserir(new CartoesPessoas(idP, cartao.getId(), msgCP));
}

Logradouro logradouro = null;
ControllerLogradouro contlog = new ControllerLogradouro();
ControllerLogradourosPessoas contlogpes = new ControllerLogradourosPessoas();
String msgLP = "Logradouro de "+nomeP;
if(idL != 0){
	contlogpes.inserir(new LogradourosPessoas(idP, idL, msgLP));
}else{
	logradouro = contlog.inserir(new Logradouro(cep, endereco, comp));
	contlogpes.inserir(new LogradourosPessoas(idP, logradouro.getId(), msgLP));
}

	    
ControllerComprasPessoas contcompes = new ControllerComprasPessoas();
contcompes.inserir(new ComprasPessoas(idP, compra.getId(), "Compra de "+nomeP));
response.sendRedirect("../home.jsp");

%>