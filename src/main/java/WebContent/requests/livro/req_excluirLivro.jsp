<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Livro"%>
<%@page import="backenddm20231n.controller.ControllerLivro"%>

<%
    
    int id_l = Integer.parseInt(request.getParameter("idL"));
    
    Livro livEntrada = new Livro(id_l);
    ControllerLivro livcont = new ControllerLivro();
	livcont.excluir(livEntrada);

    response.sendRedirect("../home.jsp");
%>