<%@page import="backenddm20231n.model.bean.Avaliacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerAvaliacao"%>

<%
    String descricao = request.getParameter("DESCRICAO");
    int nota = Integer.parseInt(request.getParameter("NOTA"));
    int id_a = Integer.parseInt(request.getParameter("ID_AVA"));
    
    Avaliacao avaEntrada = new Avaliacao(id_a, descricao, nota);
    ControllerAvaliacao avacont = new ControllerAvaliacao();
    Avaliacao avaSaida = avacont.alterar(avaEntrada);
    avaSaida = avacont.buscar(avaSaida);
    request.setAttribute("PessoaLogada", avaSaida.getPessoa());
    response.sendRedirect("../views/avaliacoes.jsp");
%>