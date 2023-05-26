<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<title>Cadastrar Livro</title>
</head>
<body>
	
	<% 
		Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
		if (usuLogado != null && usuLogado.getTipo().equals("ADMIN")) {	
	%>
	<div class="container">

		<main>
			<h1 class="mb-5 text-primary-sutle text-center">Cadastro de Livro no Estoque</h1>
			<form
				class="row g-3 needs-validation d-flex flex-row justify-content-center"
				action="../requests/req_cadastrarLivro.jsp" method="post">
				<div class="text-dark d-flex flex-column align-items-center col-6">

					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="titulo" class="fw-bold">Titulo</label> <input
								class="w-50 border-1" name="TITULO" id="titulo" type="text"
								placeholder="Titulo do livro" >
							<div class="invalid-feedback">Titulo</div>
						</div>
					</div>

					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="autor" class="fw-bold">Autor</label> <input
								class="w-50 border-1" name="AUTOR" id="autor" type="text"
								placeholder="Autor do livro" >
							<div class="invalid-feedback">Autor</div>
						</div>
					</div>
					
					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="genero" class="fw-bold">Genero</label> <input
								class="w-50 border-1" name="GENERO" id="genero" type="text"
								placeholder="Genero do livro" > 
							<div class="invalid-feedback">Genero</div>
						</div>
					</div>
					
					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="editora"
								class="fw-bold">Editora</label> <input class="w-50 border-1"
								name="EDITORA" id="editora" type="text"
								placeholder="Editora do livro" >
							<div class="invalid-feedback">Editora</div>
						</div>
					</div>
					
					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="valor"
								class="fw-bold">Valor</label> <input class="w-50 border-1"
								name="VALOR" id="valor" type="text" placeholder="Valor do livro">
							<div class="invalid-feedback">Valor</div>
						</div>
					</div>


					<div class="row mb-4 w-100 d-flex flex-row justify-content-start">
						<div class="col-md-2">
							<button type="submit" class="button btn btn-outline-dark">Cadastrar Livro</button>
						</div>
					</div>

				</div>

			</form>
		</main>
	</div>

	<% } %>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>