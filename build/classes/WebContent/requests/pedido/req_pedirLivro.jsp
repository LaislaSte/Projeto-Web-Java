<%@page import="backenddm20231n.controller.ControllerPedido"%>
<%@page import="backenddm20231n.model.bean.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>

<%
    String obs = request.getParameter("OBS");
    int quantidade = Integer.parseInt(request.getParameter("QUANTIDADE"));
    int id_p = Integer.parseInt(request.getParameter("ID_PES"));
    int id_l = Integer.parseInt(request.getParameter("ID_LIV"));
    
    Pedido pedEntrada = new Pedido(id_p, id_l, quantidade, obs);
    ControllerPedido pedcont = new ControllerPedido();
    Pedido pedSaida = pedcont.inserir(pedEntrada);
    pedSaida = pedcont.buscar(pedSaida);
    request.setAttribute("PessoaLogada", pedSaida.getPessoa());
    response.sendRedirect("../views/pedidos.jsp");
%>