<%@page import="backenddm20231n.model.bean.Usuario"%>
<%@page import="backenddm20231n.model.bean.Avaliacao"%>
<%@page import="backenddm20231n.controller.ControllerAvaliacao"%>
<%@page import="java.util.List"%>
<%@page import="backenddm20231n.model.bean.Pessoa"%>
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
    <title>Avaliacoes</title>
</head>

<body>

	<div class="container">
		<main>
		<%  Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
			Pessoa pessoaLogada = (Pessoa) request.getAttribute("PessoaLogada");
			if (usuLogado != null && pessoaLogada != null) {
				ControllerAvaliacao avacont = new ControllerAvaliacao();
				if(usuLogado.getTipo().equals("ADMIN")){ %>
				
					<h1 class="text-center mb-3">Avaliações</h1>
		            <%  List<Avaliacao> avaliacoes = avacont.listar(new Avaliacao(""));
		                if(!(avaliacoes.isEmpty())){
		                	for(Avaliacao avaliacao : avaliacoes){ %>
		
			                    <div class="row row-cols-1 row-cols-sm-2 g-3 mb-3">
			                        <div class="col bg-info-subtle">
			                            <h3 class="fw-bold mb-3"><%out.print(avaliacao.getLivro().getTitulo()); %></h3>
			
			                            <label class="fw-bold" for="autor">Autor</label>
			                            <p id="autor"><%out.print(avaliacao.getLivro().getAutor()); %></p>
			
			                            <label class="fw-bold" for="genero">Genero</label>
			                            <p id="genero"><%out.print(avaliacao.getLivro().getGenero()); %></p>
			
			                            <label class="fw-bold" for="editora">Editora</label>
			                            <p id="editora"><%out.print(avaliacao.getLivro().getEditora()); %></p>
			                        </div>
			
			                        <div class="col bg-dark-subtle">
			                            <h3 class="mb-3 fw-bold">Avaliação</h3>
			
			                            <label class="fw-bold" for="descricaolbl">Descrição</label>
			                            <p id="descricaolbl"><%out.print(avaliacao.getDescricao()); %></p>
			
			                            <label class="fw-bold" for="notalbl">Nota</label>
			                            <p id="notalbl"><%out.print(avaliacao.getNota()); %></p>
			
			                            <!-- Button trigger modal -->
			                            <div class="btn-group gap-2">
			                                <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
			                                    data-bs-target="#exampleModal">
			                                    Editar Avaliação
			                                </button>
			                                <a href="../requests/req_excluirAvaliacao.jsp?idA=<%= avaliacao.getId() %>">
			                                    <button type="button" class="btn btn-outline-danger">
			                                        Excluir Avaliação
			                                    </button>
			                                </a>
			                            </div>
			
			                            <!-- Modal -->
			                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
			                                aria-hidden="true">
			                                <div class="modal-dialog">
			                                    <div class="modal-content">
			                                        <form action="../requests/req_editarAvaliacao.jsp" method="post">
			                                            <div class="modal-body d-flex flex-column">
			                                                <input type="hidden" value=<%= avaliacao.getId() %> name="ID_AVA">
			                                                <label for="descricao" class="fw-bold">Descrição</label>
			                                                <textarea class="mb-2 p-2 border-1" name="DESCRICAO" id="descricao"
			                                                    cols="30" rows="5" placeholder="Descrição da avaliação"
			                                                    value=<%= avaliacao.getDescricao() %>></textarea>
			                                                <label for="nota" class="fw-bold">Nota</label>
			                                                <input class="w-50 border-1" name="NOTA" id="nota" type="number"
			                                                    placeholder="Nota para o livro" value=<%= avaliacao.getNota() %> >
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
		
				<% } else { %>
		
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
		                    <h1 class="text-center mb-3">Avaliações</h1>
		                    
		                    <%  List<Avaliacao> avaliacoes = avacont.listarPorPessoa(new Avaliacao(0, pessoaLogada.getId(), 0));
		                    	if(!(avaliacoes.isEmpty())){
		                    		for(Avaliacao avaliacao : avaliacoes){ %>
		
			                    <div class="row row-cols-1 row-cols-sm-2 g-3 mb-3">
			                        <div class="col bg-info-subtle">
			                            <h3 class="fw-bold mb-3"><%out.print(avaliacao.getLivro().getTitulo()); %></h3>
			
			                            <label class="fw-bold" for="autor">Autor</label>
			                            <p id="autor"><%out.print(avaliacao.getLivro().getAutor()); %></p>
			
			                            <label class="fw-bold" for="genero">Genero</label>
			                            <p id="genero"><%out.print(avaliacao.getLivro().getGenero()); %></p>
			
			                            <label class="fw-bold" for="editora">Editora</label>
			                            <p id="editora"><%out.print(avaliacao.getLivro().getEditora()); %></p>
			                        </div>
			
			                        <div class="col bg-dark-subtle">
			                            <h3 class="mb-3 fw-bold">Avaliação</h3>
			
			                            <label class="fw-bold" for="descricaolbl">Descrição</label>
			                            <p id="descricaolbl"><%out.print(avaliacao.getDescricao()); %></p>
			
			                            <label class="fw-bold" for="notalbl">Nota</label>
			                            <p id="notalbl"><%out.print(avaliacao.getNota()); %></p>
			
			                            <!-- Button trigger modal -->
			                            <div class="btn-group gap-2">
			                                <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
			                                    data-bs-target="#exampleModal">
			                                    Editar Avaliação
			                                </button>
			                                <a href="../requests/req_excluirAvaliacao.jsp?idA=<%= avaliacao.getId() %>">
			                                    <button type="button" class="btn btn-outline-danger">
			                                        Excluir Avaliação
			                                    </button>
			                                </a>
			                            </div>
			
			                            <!-- Modal -->
			                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
			                                aria-hidden="true">
			                                <div class="modal-dialog">
			                                    <div class="modal-content">
			                                        <form action="../requests/req_editarAvaliacao.jsp" method="post">
			                                            <div class="modal-body d-flex flex-column">
			                                                <input type="hidden" value=<%= avaliacao.getId() %> name="ID_AVA">
			                                                <label for="descricao" class="fw-bold">Descrição</label>
			                                                <textarea class="mb-2 p-2 border-1" name="DESCRICAO" id="descricao"
			                                                    cols="30" rows="5" placeholder="Descrição da avaliação"
			                                                    value=<%= avaliacao.getDescricao() %>></textarea>
			                                                <label for="nota" class="fw-bold">Nota</label>
			                                                <input class="w-50 border-1" name="NOTA" id="nota" type="number"
			                                                    placeholder="Nota para o livro" value=<%= avaliacao.getNota() %> >
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
		            	
			<% }} %>
		
		</main>		
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>

</html>