<%@page import="backenddm20231n.model.bean.Avaliacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerAvaliacao"%>

<%
    int id_a = Integer.parseInt(request.getParameter("idA"));
    
    Avaliacao avaEntrada = new Avaliacao(id_a);
    ControllerAvaliacao avacont = new ControllerAvaliacao();
    Avaliacao avaSaida = avacont.excluir(avaEntrada);
    response.sendRedirect("../views/avaliacoes.jsp");
%>