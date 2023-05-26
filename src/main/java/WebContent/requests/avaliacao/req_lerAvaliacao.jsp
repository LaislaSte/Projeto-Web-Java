<%@page import="backenddm20231n.model.bean.Avaliacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerAvaliacao"%>

<%
    int id_a = Integer.parseInt(request.getParameter("ID_AVA"));
    
    Avaliacao avaEntrada = new Avaliacao(id_a);
    ControllerAvaliacao avacont = new ControllerAvaliacao();
    Avaliacao avaSaida = avacont.buscar(avaEntrada);
    
    request.setAttribute("mensagem", "login Invalido");
	RequestDispatcher disp = request.getRequestDispatcher("../index.jsp");
	disp.forward(request, response);
	
    response.sendRedirect("../views/avaliacoes.jsp");
%>