<%@page import="backenddm20231n.model.bean.CartoesPessoas"%>
<%@page import="backenddm20231n.controller.ControllerCartoesPessoas"%>
<%@page import="backenddm20231n.model.bean.LogradourosPessoas"%>
<%@page import="backenddm20231n.controller.ControllerLogradourosPessoas"%>
<%@page import="java.util.List"%>
<%@page import="backenddm20231n.model.bean.Pessoa"%>
<%@page import="backenddm20231n.controller.ControllerPessoa"%>
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
    <title>Compra</title>
</head>

<body>

    <div class="container">
        <main>
            <div class="row g-5 row-cols-1 row-cols-md-2">
            
            	<% 
            		int id_pes = Integer.parseInt(request.getParameter("id_pes"));
            		ControllerPessoa cp = new ControllerPessoa();
            		Pessoa pes = new Pessoa(id_pes);
            		Pessoa pessoa = cp.buscar(pes);
            		ControllerLogradourosPessoas clp = new ControllerLogradourosPessoas();
            		List<LogradourosPessoas> listaLP = clp.listarPorPessoa(pes);
            		
            		ControllerCartoesPessoas ccp = new ControllerCartoesPessoas();
            		List<CartoesPessoas> listaCP = ccp.listarPorPessoa(pes);
            	%>

                <div class="col-md-4 bg-body-secondary py-3">
                    <h1 class="text-center mb-3">Perfil</h1>

                    <label class="fw-bold" for="nome">Nome</label>
                    <p id="nome"><%out.print(pessoa.getNome()); %></p>

                    <label class="fw-bold" for="email">E-mail</label>
                    <p id="email"><%out.print(pessoa.getEmail()); %></p>
                </div>

                <div class="col-md-8 py-3 mb-4 bg-body-tertiary">
                    <form action="compra" method="post" class="d-flex flex-column">
                    	<input type="hidden" value=<%=pessoa.getId()%> name="ID_PES">
                    	<input type="hidden" value=<%=pessoa.getNome()%> name="NOME_PESSOA">
                    	
                        <h2 class="mt-3">Endereço para Entrega</h2>
                        <% if(listaLP != null){ %> 
                        <div class="mb-3">
                        	<label for="logradouro_select" class="fw-bold form-label">Selecione um Endereco</label>
                        	<select name="ID_LOG" id="logradouro_select" class="form-select w-75" aria-label="Default select example"
                            onclick="selectedLog(this.value)">
                        		<option selected >Selecione um Endereco</option>
                        		<% for(LogradourosPessoas lp : listaLP){ %>
                        			<option value=<%= lp.getIdL() %> ><%out.print(lp.getLogradouro().toString()); %></option>
                        		<% } %>
                        	</select>
                        </div>
                        <% } %>
                        
                        <div class="form_logradouro" style="display:block;">
	                        <div class="mb-3">
	                            <label for="cep" class="fw-bold form-label">Cep</label>
	                            <input class="w-75 border-1 form-control" name="CEP" id="cep" type="text"
	                                placeholder="Cep do local">
	                        </div>
	                        <div class="mb-3">
	                            <label for="endereco" class="fw-bold form-label">Endereco</label>
	                            <input class="w-75 border-1 form-control" name="ENDERECO" id="endereco" type="text"
	                                placeholder="Numero da casa">
	                        </div>
	                        <div class="mb-3">
	                            <label for="comp" class="fw-bold form-label">Complemento</label>
	                            <textarea class="mb-2 p-2 border-1 form-control w-50" name="COMP" id="comp" cols="30"
	                                rows="5" placeholder="Complemento do endereço"></textarea>
	                        </div>                        
                        </div>
                        
                        <h2>Selecione Forma de Pagamento</h2>
                        
                        <select class="form-select w-75" aria-label="Default select example"
                            onclick="selected(this.value)" id="formaPagamento" name="FORMA_PAGAMENTO">
                            <option selected>Selecionar forma de pagamento</option>
                            <option value="Cartao">Cartao</option>
                            <option value="Boleto">Boleto</option>
                        </select>
                        
                        <div class="form_cartao" style="display:none;">
                            <h2 class="mt-3">Formulario de Cartao</h2>           
                            <% if(listaCP!= null){ %> 
                        		<div class="mb-3">
		                        	<label for="cartao_select" class="fw-bold form-label">Selecione um Cartao</label>
		                        	<select name="ID_CAR" id="cartao_select" class="form-select w-75" aria-label="Default select example"
		                            	onclick="selectedCar(this.value)">
		                        		<option selected >Selecione um Cartao</option>
		                        		<% for(CartoesPessoas carpes : listaCP){ %>
		                        			<option value=<%= carpes.getIdC() %> ><%out.print(carpes.getCartao().toString()); %></option>
		                        		<% } %>
		                        	</select>
		                        </div>
		                    <% } %>

							<div class="in_form_cartao" style="display:block;">
							
								<div class="mb-3">
	                                <label for="numeroSerie" class="fw-bold form-label">Numero do Cartão</label>
	                                <input class="w-75 border-1 form-control" name="NUM_SERIE" id="numeroSerie"
	                                    type="text" placeholder="Numero de Serie 1234.4234-443">
	                            </div>
	                            <div class="mb-3">
	                                <label for="banco" class="fw-bold form-label">Banco</label>
	                                <input class="w-75 border-1 form-control" name="BANCO" id="banco" type="text"
	                                    placeholder="Banco do Cartão">
	                            </div>
	                            <div class="mb-3">
	                                <label for="dataVencimento" class="fw-bold form-label">Data de Vencimento</label>
	                                <input type="date" class="form-control w-50" name="DATA_VENCIMENTO" id="dataVencimento">
	                            </div>
	                            
	                        </div>
                        </div>

                        <button type="submit" class="btn btn-outline-dark w-25">Finalizar Compra</button>
                    </form>
                </div>

            </div>

        </main>
    </div>

    <script>
        function selected(value) {
            var form_cartao = document.getElementsByClassName('form_cartao');
            if (value == "Cartao") {
                form_cartao[0].style.display = 'block';
            } else {
                form_cartao[0].style.display = 'none';
            }
        }
        
        function selectedLog(value) {
            var form_logradouro = document.getElementsByClassName('form_logradouro');
            if (value != "Selecione um Endereco") {
                form_logradouro[0].style.display = 'none';
            } else {
                form_logradouro[0].style.display = 'block';
            }
        }
        
        function selectedCar(value) {
            var in_form_cartao = document.getElementsByClassName('in_form_cartao');
            if (value != "Selecione um Cartao") {
                form_logradouro[0].style.display = 'none';
            } else {
                form_logradouro[0].style.display = 'block';
            }
        }
        
        
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>

</html>