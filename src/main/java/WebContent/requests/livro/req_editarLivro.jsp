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
    int id_l = Integer.parseInt(request.getParameter("ID_LIV"));
    
    Livro livEntrada = new Livro(id_l, titulo, autor, genero, editora, valor);
    ControllerLivro livcont = new ControllerLivro();
	livcont.alterar(livEntrada);

    response.sendRedirect("../home.jsp");
%>