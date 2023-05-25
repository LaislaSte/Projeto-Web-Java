<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    
    Usuario usuEntrada = new Usuario(login,senha);
    ControllerUsuario usucont = new ControllerUsuario();
    Usuario usuSaida = usucont.validarWeb(usuEntrada);
    
    if(usuSaida != null){
	    session.setAttribute("UsuarioLogado",usuSaida);
	    response.sendRedirect("home.jsp");
    }else{
    	response.sendRedirect("index.html");
    	request.setAttribute("mensagem", "login Invalido");
		RequestDispatcher disp = request.getRequestDispatcher("index.html");
		disp.forward(request, response);
    }
%>