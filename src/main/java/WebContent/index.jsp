<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pagina Inicial</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
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
			<h1 class="mb-5 text-primary-sutle text-center">Login</h1>
			<form
				class="row g-3 needs-validation d-flex flex-row justify-content-center"
				action="requests/login.jsp" method="post">
				<div class="text-dark d-flex flex-column align-items-center col-6">

					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="login" class="form-label fw-bold">Login</label> <input
								type="text" class="form-control" id="login" name="LOGIN"
								placeholder="Nome de Acesso" required />
							<div class="invalid-feedback">Login</div>
						</div>
					</div>

					<div class="row mb-4 w-100 d-flex flex-row justify-content-center">
						<div class="col">
							<label for="senha" class="form-label fw-bold">Senha</label> <input
								type="password" class="form-control" id="senha" name="SENHA"
								placeholder="Senha de acesso" required />
							<div class="invalid-feedback">Senha.</div>
						</div>
					</div>

					<div class="row mb-4 w-100 d-flex flex-row justify-content-start">
						<div class="col-md-2">
							<button type="submit" class="button btn btn-outline-dark">Acessar</button>
						</div>
					</div>
					
					<% 
						String msg = (String) request.getAttribute("mensagem");
						if(msg!=null){
					%>
					<div class="row mb-4 w-100 d-flex flex-row justify-content-start">
						<div class="col-md-2">
							<label class="form-label fw-bold"><%out.print(msg); %></label>
						</div>
					</div>
					<% } %>

				</div>

			</form>
		</main>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>