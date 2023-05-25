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
            <div class="row g-5 row-cols-1 row-cols-md-2">

                <div class="col-md-4 bg-body-secondary py-3">
                    <h1 class="text-center mb-3">Perfil</h1>

                    <label class="fw-bold" for="nome">Nome</label>
                    <p id="nome">Julia Martins</p>

                    <label class="fw-bold" for="email">E-mail</label>
                    <p id="email">juliamartins@gmail.com</p>

                    <label class="fw-bold" for="bio">Biografia</label>
                    <p id="bio">Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium voluptate
                        numquam delectus quisquam ullam autem.</p>

                </div>

                <div class="col-md-8 py-3 bg-body-tertiary">
                    <h1 class="text-center mb-3">Avalia��es</h1>

                    <div class="row row-cols-1 row-cols-sm-2 g-3 mb-3">
                        <div class="col bg-info-subtle">
                            <h3 class="fw-bold mb-3">T�tulo do livro</h3>

                            <label class="fw-bold" for="autor">Autor</label>
                            <p id="autor">Joana Dark</p>

                            <label class="fw-bold" for="genero">Genero</label>
                            <p id="genero">Romance</p>

                            <label class="fw-bold" for="editora">Editora</label>
                            <p id="editora">Joana Dark</p>
                        </div>

                        <div class="col bg-dark-subtle">
                            <h3 class="mb-3 fw-bold">Avalia��o</h3>

                            <label class="fw-bold" for="descricaolbl">Descri��o</label>
                            <p id="descricaolbl">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa
                                quaerat sapiente reprehenderit ratione nostrum laboriosam.</p>

                            <label class="fw-bold" for="notalbl">Nota</label>
                            <p id="notalbl">10</p>

                            <!-- Button trigger modal -->
                            <div class="btn-group gap-2">
                                <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal">
                                    Editar Avalia��o
                                </button>
                                <a href="excluirAvaliacao">
                                    <button type="button" class="btn btn-outline-danger">
                                        Excluir Avalia��o
                                    </button>
                                </a>
                            </div>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="editarAvaliacao" method="post">
                                            <div class="modal-body d-flex flex-column">
                                                <input type="hidden" value="id_vindo_do_post">
                                                <label for="descricao" class="fw-bold">Descri��o</label>
                                                <textarea class="mb-2 p-2 border-1" name="descricao" id="descricao"
                                                    cols="30" rows="5" placeholder="Descri��o da avalia��o"
                                                    value="valor_do_for"></textarea>
                                                <label for="nota" class="fw-bold">Nota</label>
                                                <input class="w-50 border-1" name="nota" id="nota" type="number"
                                                    placeholder="Nota para o livro" value="valor_do_for">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary"
                                                    data-bs-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-primary">Save changes</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </main>


    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>

</html>