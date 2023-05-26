<%@page import="backenddm20231n.model.bean.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.controller.ControllerPedido"%>

<%
    int id_p = Integer.parseInt(request.getParameter("idP"));
    
    Pedido pedEntrada = new Pedido(id_p);
    ControllerPedido pedcont = new ControllerPedido();
    Pedido pedSaida = pedcont.excluir(pedEntrada);
    response.sendRedirect("../views/pedidos.jsp");
%>