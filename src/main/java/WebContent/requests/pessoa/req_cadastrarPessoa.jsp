<%@page import="backenddm20231n.model.bean.UsuariosPessoas"%>
<%@page import="backenddm20231n.controller.ControllerUsuariosPessoas"%>
<%@page import="backenddm20231n.controller.ControllerPessoa"%>
<%@page import="backenddm20231n.model.bean.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerUsuario"%>

<%
    String nome = request.getParameter("NOME");
    String email = request.getParameter("EMAIL");
    String cpf_cnpj = request.getParameter("CPF_CNPJ");
    String tipo = request.getParameter("TIPO");
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    
    Pessoa pesEntrada = new Pessoa(nome, cpf_cnpj, tipo, email);
    ControllerPessoa pescont = new ControllerPessoa();
    Pessoa pesSaida = pescont.inserir(pesEntrada);
    
    ControllerUsuariosPessoas contUsuPes = new ControllerUsuariosPessoas();
    String msg = "Login do usuario "+usuLogado.getLogin()+" cadastrado com pessoa de "
    			+ pesSaida.getTipo()+ " " +pesSaida.getCpf();
    contUsuPes.inserir(new UsuariosPessoas(usuLogado.getId(), pesSaida.getId(), msg ));

    request.setAttribute("pessoaLogada", pesSaida);
	response.sendRedirect("../home.jsp");
   
%>