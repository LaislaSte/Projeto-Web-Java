<%@page import="backenddm20231n.model.bean.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="backenddm20231n.controller.ControllerPedido"%>
<%@page import="backenddm20231n.model.bean.Pessoa"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Pedidos</title>
</head>

<body>

    <div class="container">
	    <%
		    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
			if (usuLogado != null) {
				Pessoa pessoaLogada = (Pessoa) request.getAttribute("PessoaLogada");
				if(pessoaLogada != null)
		%>
		        <main>
		            <div class="row g-5 row-cols-1 row-cols-md-2">
		
		                <div class="col-md-4 bg-body-secondary py-3">
		                    <h1 class="text-center mb-3">Perfil</h1>
		
		                    <label class="fw-bold" for="nome">Nome</label>
		                    <p id="nome"><%out.print(pessoaLogada.getNome()); %></p>
		
		                    <label class="fw-bold" for="email">E-mail</label>
		                    <p id="email"><%out.print(pessoaLogada.getEmail()); %></p>
		
		                    <label class="fw-bold" for="bio">Biografia</label>
		                    <p id="bio">Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium voluptate
		                        numquam delectus quisquam ullam autem.</p>
		
		                </div>
		
		                <div class="col-md-8 py-3 bg-body-tertiary">
		                    <h1 class="text-center mb-3">Pedidos</h1>
		                    
		                    <% 
		                    	ControllerPedido pedcont = new ControllerPedido();
			                    List<Pedido> pedidos = pedcont.listar(new Pedido(""));
		                    	if(!(pedidos.isEmpty())){
		                    		for(Pedido pedido : pedidos){
		                    %>
		
				                    <div class="row row-cols-1 row-cols-sm-2 g-3 mb-3">
				                        <div class="col bg-info-subtle">
				                            <h3 class="fw-bold mb-3"><%out.print(pedido.getLivro().getTitulo()); %></h3>
			
				                            <label class="fw-bold" for="autor">Autor</label>
				                            <p id="autor"><%out.print(pedido.getLivro().getAutor()); %></p>
				
				                            <label class="fw-bold" for="genero">Genero</label>
				                            <p id="genero"><%out.print(pedido.getLivro().getGenero()); %></p>
				
				                            <label class="fw-bold" for="editora">Editora</label>
				                            <p id="editora"><%out.print(pedido.getLivro().getEditora()); %></p>
				                        </div>
				
				                        <div class="col bg-dark-subtle">
				                            <h3 class="mb-3 fw-bold">Pedido</h3>
				
				                            <label class="fw-bold" for="obslbl">Observacao do Pedido</label>
				                            <p id="obslbl"><%out.print(pedido.getObs()); %></p>
				
				                            <label class="fw-bold" for="quantlbl">Quantidade</label>
				                            <p id="quantlbl"><%out.print(pedido.getQuantidade()); %></p>
				
				                            <!-- Button trigger modal -->
				                            <div class="btn-group gap-2">
				                                <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
				                                    data-bs-target="#exampleModal">
				                                    Editar Pedido
				                                </button>
				                                <a href="../requests/req_excluirPedido.jsp?idP=<%= pedido.getId() %>">
				                                    <button type="button" class="btn btn-outline-danger">
				                                        Excluir Pedido
				                                    </button>
				                                </a>
				                            </div>
				
				                            <!-- Modal -->
				                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
				                                aria-hidden="true">
				                                <div class="modal-dialog">
				                                    <div class="modal-content">
				                                        <form action="../requests/req_editarPedido.jsp" method="post">
				                                            <div class="modal-body d-flex flex-column">
				                                                <input type="hidden" value=<%= pedido.getId() %> name="ID_PED">
				                                                <label for="obs" class="fw-bold">Observação</label>
				                                                <textarea class="mb-2 p-2 border-1" name="OBS" id="obs" cols="30"
				                                                    rows="5" placeholder="Descrição da avaliação"
				                                                    value=<%= pedido.getObs() %>></textarea>
				
				                                                <label for="quantidade" class="fw-bold">Quantidade</label>
				                                                <input class="w-50 border-1" name="QUANTIDADE" id="quantidade"
				                                                    type="number" placeholder="Quantidade de livro"
				                                                    value=<%= pedido.getQuantidade() %>>
				                                            </div>
				                                            <div class="modal-footer">
				                                                <button type="button" class="btn btn-secondary"
				                                                    data-bs-dismiss="modal">Close</button>
				                                                <button type="submit" class="btn btn-primary">Salvar Mudancas</button>
				                                            </div>
				                                        </form>
				                                    </div>
				                                </div>
				                            </div>
				
				                        </div>
				                    </div>
				                
		                	<% }} %>
		                </div>
		            </div>
		
		
		            <div class="fixed-bottom d-flex justify-content-end m-5">
		                <a href="realizarCompra.html" class="btn btn-primary w-25">
		                    Realizar Compra
		                </a>
		            </div>
		        </main>
		
		<% } %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>

</html>