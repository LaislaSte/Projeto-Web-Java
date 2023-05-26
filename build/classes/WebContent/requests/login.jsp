<%@page import="backenddm20231n.model.bean.UsuariosPessoas"%>
<%@page import="backenddm20231n.controller.ControllerUsuariosPessoas"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    
    Usuario usuEntrada = new Usuario(login,senha);
    ControllerUsuario usucont = new ControllerUsuario();
    Usuario usuSaida = usucont.validarWeb(usuEntrada);
    
    if(usuSaida != null){
	    ControllerUsuariosPessoas contUsuPes = new ControllerUsuariosPessoas();
	    UsuariosPessoas up = contUsuPes.buscarPorUsuario(usuSaida);
    		    	    
	    session.setAttribute("UsuarioLogado",usuSaida);
	    request.setAttribute("pessoaLogada", up.getPes());
	    response.sendRedirect("../home.jsp");
    }else{
    	request.setAttribute("mensagem", "login Invalido");
		RequestDispatcher disp = request.getRequestDispatcher("../index.jsp");
		disp.forward(request, response);
    	response.sendRedirect("../index.jsp");
    }
%>