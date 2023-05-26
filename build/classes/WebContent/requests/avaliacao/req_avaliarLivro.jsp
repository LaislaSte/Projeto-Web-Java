<%@page import="backenddm20231n.model.bean.Avaliacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerAvaliacao"%>

<%
    String descricao = request.getParameter("DESCRICAO");
    int nota = Integer.parseInt(request.getParameter("NOTA"));
    int id_p = Integer.parseInt(request.getParameter("ID_PES"));
    int id_l = Integer.parseInt(request.getParameter("ID_LIV"));
    
    Avaliacao avaEntrada = new Avaliacao(id_p, id_l, descricao, nota);
    ControllerAvaliacao avacont = new ControllerAvaliacao();
    Avaliacao avaSaida = avacont.inserir(avaEntrada);
    avaSaida = avacont.buscar(avaSaida);
    request.setAttribute("PessoaLogada", avaSaida.getPessoa());
    response.sendRedirect("../views/avaliacoes.jsp");
%>