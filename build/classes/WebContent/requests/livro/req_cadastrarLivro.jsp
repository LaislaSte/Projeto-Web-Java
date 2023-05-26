<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Livro"%>
<%@page import="backenddm20231n.controller.ControllerLivro"%>

<%
    String titulo = request.getParameter("TITULO");
	String autor = request.getParameter("AUTOR");
	String genero = request.getParameter("GENERO");
	String editora = request.getParameter("EDITORA");
    Double valor = Double.parseDouble(request.getParameter("VALOR"));
    
    Livro livEntrada = new Livro(titulo, autor, genero, editora, valor);
    ControllerLivro livcont = new ControllerLivro();
	livcont.inserir(livEntrada);

    response.sendRedirect("../home.jsp");
%>