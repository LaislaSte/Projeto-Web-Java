<%@page import="backenddm20231n.model.bean.Livro"%>
<%@page import="backenddm20231n.controller.ControllerLivro"%>
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
    <title>Pedir Livro</title>
</head>

<body>

    <div class="container">
      <% 
      	String idP = (String) request.getParameter("idP");
    	String idL = (String) request.getParameter("idL");
    	%>
        <main>
            <div class="row g-5 row-cols-1 row-cols-md-2">
                <div class=" col py-3">
                    <form action="../requests/req_pedirLivro.jsp" method="post" class="d-flex flex-column">
                        <input type="hidden" value=<%= idP %> name="ID_PES">
                        <input type="hidden" value=<%= idL %> name="ID_LIV">
                        
                        <h1 class="text-center mb-3">Pedido</h1>
                        <label for="obs" class="fw-bold">Observa��o</label>
                        <textarea class="mb-2 p-2 border-1" name="OBS" id="obs" cols="30" rows="5"
                            placeholder="Observa��o para o pedido"></textarea>
                        <label for="quantidade" class="fw-bold">Quantidade</label>
                        <input class="w-50 border-1 mb-3" name="QUANTIDADE" id="quantidade" type="number" min="1" max="10"
                            placeholder="Quantidade de livro">

                        <input type="submit" class=" btn btn-dark w-50" value="Pedir Livro">
                    </form>
                </div>

                <div class=" col py-3">
                    <% ControllerLivro cl = new ControllerLivro();
                       Livro livro = cl.buscar( new Livro(idL));
					%>
                    <h1 class="text-center mb-3"><% out.print(livro.getTitulo()); %></h1>

                    <label class="fw-bold" for="autor">Autor</label>
                    <p id="autor"><% out.print(livro.getAutor()); %></p>

                    <label class="fw-bold" for="genero">Genero</label>
                    <p id="genero"><% out.print(livro.getGenero()); %></p>

                    <label class="fw-bold" for="editora">Editora</label>
                    <p id="editora"><% out.print(livro.getEditora()); %></p>

                    <label class="fw-bold" for="valor">Valor</label>
                    <p id="valor"><% out.print(livro.getValor()); %></p>

                    <label class="fw-bold" for="enredo">Enredo</label>
                    <p id="enredo">Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque at, sapiente
                        repudiandae accusantium culpa porro, perferendis unde quas blanditiis eveniet praesentium! Nulla
                        iste eveniet laboriosam adipisci quis amet praesentium sapiente.</p>

                </div>

            </div>
        </main>


    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>

</html>