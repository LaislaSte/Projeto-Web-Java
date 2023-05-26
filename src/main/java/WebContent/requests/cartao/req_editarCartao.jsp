<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Cartao"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerCartao"%>

<%
	String numSerie = request.getParameter("NUM_SERIE");
	String banco = request.getParameter("BANCO");
	String dataVencimento = request.getParameter("DATA_VENCIMENTO");
    int id_c = Integer.parseInt(request.getParameter("ID_CAR"));
    
    Cartao avaEntrada = new Cartao(id_c, numSerie, banco, Date.valueOf(dataVencimento));
    ControllerCartao avacont = new ControllerCartao();
    Cartao avaSaida = avacont.alterar(avaEntrada);
    
    //posso procurar a pessoa na tabela de relacoes aqui e mandar com o id
    response.sendRedirect("../views/cartoes.jsp");
%>