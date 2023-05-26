<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Cartao"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerCartao"%>

<%
	int id_c = Integer.parseInt(request.getParameter("ID_CAR"));
    
    Cartao avaEntrada = new Cartao(id_c);
    ControllerCartao avacont = new ControllerCartao();
    avacont.excluir(avaEntrada);
    
    //posso procurar a pessoa na tabela de relacoes aqui e mandar com o id
    //verifica se ha outros cartoes
    //se houver manda com o id se nao manda para o perifl
    response.sendRedirect("../views/cartoes.jsp");
%>