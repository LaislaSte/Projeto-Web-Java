<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Livro"%>
<%@page import="backenddm20231n.controller.ControllerLivro"%>

<%
    
    int id_l = Integer.parseInt(request.getParameter("ID_LIV"));
    
    Livro livEntrada = new Livro(id_l);
    ControllerLivro livcont = new ControllerLivro();
	Livro livro = livcont.buscar(livEntrada);
	//Redireciona pra onde chamar
	request.setAttribute("mensagem", "login Invalido");
	RequestDispatcher disp = request.getRequestDispatcher("../index.jsp");
	disp.forward(request, response);
    response.sendRedirect("../home.jsp");
%>