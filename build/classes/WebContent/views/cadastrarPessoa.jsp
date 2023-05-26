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
<title>Cadastrar Pessoa</title>
</head>
<body>
	
	<% 
		Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
		if (usuLogado != null) {	
	%>
	<div class="container">

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
								aria-current="page" href="/">Login</a></li>
							<li class="nav-item"><a class="nav-link"
								href="views/cadastrarUsuario.jsp">Cadastrar</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>


		<main>
			<h1 class="mb-5 text-primary-sutle text-center">Necessario Cadastrar Pessoa</h1>
			<form
				class="row g-3 needs-validation d-flex flex-row justify-content-center"
				action="../requests/req_cadastrarPessoa.jsp" method="post">
				<div class="text-dark d-flex flex-column align-items-center col-6">

					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="nome" class="form-label fw-bold">Nome</label> <input
								type="text" class="form-control" id="nome" name="NOME"
								placeholder="Nome de Perfil" required />
							<div class="invalid-feedback">Nome</div>
						</div>
					</div>

					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="CPF_CNPJ" class="form-label fw-bold">CPF ou CNPJ</label> <input
								type="text" class="form-control" id="CPF_CNPJ" name="CPF_CNPJ"
								placeholder="Identificacao de Pessoa Fisica ou Juridica" required />
							<div class="invalid-feedback">CPF ou CNPJ</div>
						</div>
					</div>
					
					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="email" class="form-label fw-bold">E-mail</label> <input
								type="email" class="form-control" id="email" name="EMAIL"
								placeholder="E-mail da Pessoa" required />
							<div class="invalid-feedback">E-mail</div>
						</div>
					</div>

					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="tipo" class="form-label fw-bold">Tipo</label> <select
								id="tipo" name="TIPO" class="form-select"
								aria-label="Default select example">
								<option selected>Selecione tipo do documento</option>
								<option value="CPF">CPF</option>
								<option value="CNPJ">CNPJ</option>
							</select>
							<div class="invalid-feedback">Tipo</div>
						</div>
					</div>

					<div class="row mb-4 w-100 d-flex flex-row justify-content-start">
						<div class="col-md-2">
							<button type="submit" class="button btn btn-outline-dark">Cadastrar Pessoa</button>
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