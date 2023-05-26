<%@page import="backenddm20231n.model.bean.Pessoa"%>
<%@page import="backenddm20231n.model.bean.Livro"%>
<%@page import="java.util.List"%>
<%@page import="backenddm20231n.controller.ControllerLivro"%>
<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

<title>Livraria Web</title>
</head>
</head>
<body>

	<div class="container">

		<% 
			Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
			if (usuLogado != null) {
			Pessoa pessoaLogada = (Pessoa) request.getAttribute("PessoaLogada");
		%>

			<header class="mb-4 border-bottom border-primary-subtle">
				<nav class="navbar navbar-expand-lg bg-body-tertiary">
					<div class="container-fluid">
						<a class="navbar-brand" href="#">Navbar</a>
						<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
						<div class="collapse navbar-collapse" id="navbarNav">
							<ul class="navbar-nav">

								<%if (usuLogado.getTipo().equals("ADMIN")) {%>
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="views/cadastrarLivro.jsp">Cadastrar Livro</a></li>
								<li class="nav-item"><a class="nav-link"
									href="views/compras.jsp">Compras no Sistema</a></li>
								<li class="nav-item"><a class="nav-link"
									href="views/pedidos.jsp">Pedidos no Sistema</a></li>
								<%}%>
								
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="views/pedidos.jsp?idP=<%=pessoaLogada.getId()%>">Pedidos</a></li>
								<li class="nav-item"><a class="nav-link"
									href="views/avaliacoes.jsp?idP=<%=pessoaLogada.getId()%>">Avaliacoes</a></li>
								<li class="nav-item"><a class="nav-link" href="compras.jsp?idP=<%=pessoaLogada.getId()%>">Compras Realizadas</a></li>

							</ul>
						</div>
					</div>
				</nav>
			</header>

			<main>
				<h1 class="mb-5 text-primary-sutle text-center">Lista de Livro</h1>
				<%
				ControllerLivro cl = new ControllerLivro();
				List<Livro> livros = cl.listar(new Livro(""));
				for (Livro livro : livros) {
				%>
					<div class="container text-center">
						<div class="row g-5 p-3 bg-primary flex-row justify-content-center ">
		                    <div class="col-auto ">
		                    	<div class="card" style="width: 18rem;">
        		                    <div class="card-body">
                		                <h5 class="card-title"> <% out.print(livro.getTitulo()); %></h5>
                        		        <h6 class="card-subtitle mb-2 text-muted"><% out.print(livro.getEditora()); %></h6>
                        		        <p class="card-text"><% out.print(livro.getGenero()); %></p>
                        		        <p class="card-text">  <%out.print(livro.getValor()); %> </p>
                        		        
										<% if (usuLogado.getTipo().equals("ADMIN")) { %>
											<!-- Button trigger modal -->
			                            <div class="btn-group gap-2">
			                                <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
			                                    data-bs-target="#exampleModal">
			                                    Editar Livro
			                                </button>
			                                <a href="requests/req_excluirLivro.jsp?idL=<%= livro.getId() %>">
			                                    <button type="button" class="btn btn-outline-danger">
			                                        Excluir Livro
			                                    </button>
			                                </a>
			                            </div>
			
			                            <!-- Modal -->
			                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
			                                aria-hidden="true">
			                                <div class="modal-dialog">
			                                    <div class="modal-content">
			                                        <form action="requests/req_editarLivro.jsp" method="post">
			                                            <div class="modal-body d-flex flex-column">
			                                                <input type="hidden" value=<%= livro.getId() %> name="ID_LIV">
															
			                                                <label for="titulo" class="fw-bold">Titulo</label>
			                                                <input class="w-50 border-1" name="TITULO" id="titulo" type="text"
			                                                    placeholder="Titulo do livro" value=<%= livro.getTitulo() %> >
			                                                    
			                                                <label for="autor" class="fw-bold">Autor</label>
			                                                <input class="w-50 border-1" name="AUTOR" id="autor" type="text"
			                                                    placeholder="Autor do livro" value=<%= livro.getAutor() %> >
			                                                    
			                                                <label for="genero" class="fw-bold">Genero</label>
			                                                <input class="w-50 border-1" name="GENERO" id="genero" type="text"
			                                                    placeholder="Genero do livro" value=<%= livro.getGenero() %> >
			                                                    
			                                                <label for="editora" class="fw-bold">Editora</label>
			                                                <input class="w-50 border-1" name="EDITORA" id="editora" type="text"
			                                                    placeholder="Editora do livro" value=<%= livro.getEditora() %> >
			                                                    
			                                                <label for="valor" class="fw-bold">Valor</label>
			                                                <input class="w-50 border-1" name="VALOR" id="valor" type="text"
			                                                    placeholder="Valor do livro" value=<%= livro.getValor() %> >
			                                                    
			                                            
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
			                            
										<% } else { %>
	        	                        	<a href="views/avaliarLivro.jsp?idP=<%= pessoaLogada.getId() %>?idL=<%=livro.getId() %>" 
	        	                        	  	class="card-link">Avaliar</a>
    		                            	<a href="views/pedirLivro.jsp?idP=<%= pessoaLogada.getId() %>?idL=<%=livro.getId() %>" 
    		                            		class="card-link">Pedir</a>
										<% } %>
                		            </div>
                        		</div>
							</div>
						</div>
					</div>
			<% } %>

		</main>

		<% } else { %>

			<header class="mb-4 border-bottom border-primary-subtle">
				<nav class="navbar navbar-expand-lg bg-body-tertiary">
					<div class="container-fluid">
						<a class="navbar-brand" href="#">Navbar</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse" data-bs-target="#navbarNav"
							aria-controls="navbarNav" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNav">
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="index.jsp">Login</a></li>
								<li class="nav-item"><a class="nav-link"
									href="views/cadastrarUsuario.jsp">Cadastrar</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</header>

		<% } %>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>