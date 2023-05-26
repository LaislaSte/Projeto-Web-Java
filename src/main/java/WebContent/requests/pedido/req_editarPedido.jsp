<%@page import="backenddm20231n.model.bean.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerPedido"%>

<%
    String obs = request.getParameter("OBS");
    int quant = Integer.parseInt(request.getParameter("QUANTIDADE"));
    int id_p = Integer.parseInt(request.getParameter("ID_PED"));
    
    Pedido pedEntrada = new Pedido(id_p, quant, obs);
    ControllerPedido pedcont = new ControllerPedido();
    Pedido pedSaida = pedcont.alterar(pedEntrada);
    pedSaida = pedcont.buscar(pedSaida);
    request.setAttribute("PessoaLogada", pedSaida.getPessoa());
    response.sendRedirect("../views/pedidos.jsp");
%>