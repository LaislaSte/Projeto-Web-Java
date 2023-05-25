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

		<% Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
		if (usuLogado != null) {%>

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
									aria-current="page" href="pedidos.jsp?id=<%=usuLogado.getId()%>">Pedidos</a></li>
								<li class="nav-item"><a class="nav-link"
									href="avaliacoes.jsp?id=<%=usuLogado.getId()%>">Avaliacoes</a></li>
								<li class="nav-item"><a class="nav-link" href="compras.jsp?id=<%=usuLogado.getId()%>">Compras Realizadas</a></li>

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
											<a href="avaliarLivro.jsp?idL=<%= livro.getId() %>" class="card-link">Editar</a>
    		                            	<a href="pedirLivro.jsp?idL=<%= livro.getId() %>" class="card-link">Excluir</a>
										<% } else { %>
	        	                        	<a href="views/avaliarLivro.jsp?idP=<%= usuLogado.getId() %>?idL=<%=livro.getId() %>" 
	        	                        	  	class="card-link">Avaliar</a>
    		                            	<a href="views/pedirLivro.jsp?idP=<%= usuLogado.getId() %>?idL=<%=livro.getId() %>" 
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