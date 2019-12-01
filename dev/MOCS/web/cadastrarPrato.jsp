<%-- 
    Document   : cadastroRefeicao
    Created on : 07/09/2019, 18:45:11
    Author     : Aaron Stiebler & Débora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${operacao} Prato</title>
        <%-- Estilos, scripts e dependências de terceiros --%>
        <link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css"/>
        <script src="vendor/jquery-3.3.1.slim.min.js"></script>
        <script src="vendor/popper.min.js"></script>
        <script src="vendor/bootstrap/bootstrap.min.js"></script>
        <%-- Estilos e scripts próprios --%>
        <link rel="stylesheet" href="./css/main.css"/>
        <script src="./js/filtros.js"></script>
    </head>
    <body>
        <h1>${operacao} Prato</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li><a href="PesquisarPratoController">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <form id="incluir" action="ManterPratoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterPrato" method="post" onsubmit="return validarFormulario(this)">
            <table border="1">
                <tbody>
                    <tr>
                        <td><label>Funcionario:</label></td>
                        <td>
                            <select name="txtIdFuncionario">
                                <option value="0" <c:if test="${prato.idFuncionario == null}"> selected</c:if>> </option>  
                                <c:forEach items="${funcionarios}" var="funcionario">                                    
                                    <option value="${funcionario.id}" <c:if test="${prato.idFuncionario == funcionario.id}"> selected</c:if>>${funcionario.nome}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Estabelecimento:</label></td>
                        <td>
                            <select name="txtIdEstabelecimento">
                                <option value="0" <c:if test="${prato.idEstabelecimento == null}"> selected</c:if>> </option>  
                                <c:forEach items="${estabelecimentos}" var="estabelecimento">
                                    <option value="${estabelecimento.id}" <c:if test="${prato.idEstabelecimento == estabelecimento.id}"> selected</c:if>>${estabelecimento.nomeFantasia}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>                    
                    <tr>
                        <td><label for="id">Id:</label></td>
                        <td><input type="text" name="txtId" id="idPrato" maxlength="10" value="${prato.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" maxlength="45" value="${prato.nome}"/></td>
                    </tr>
                    <tr>
                        <td><label for="descricao">Descricao:</label></td>
                        <td><input type="text" name="txtDescricao" id="descricao" maxlength="60" value="${prato.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="imagem">Url da Imagem:</label></td>
                            <td><input type="text" name="txtImagemUrl" id="imagem" value="${prato.imagemUrl}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="preco">Preco</label></td>
                            <td><input type="text" name="txtPreco" id="preco" maxlength="12" placeholder="00.00" value="${prato.preco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="dataCriacao">Data da Criação:</label></td>
                            <td><input type="date" name="txtDataCriacao" id="dataCriacao" value="${prato.dataCriacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label>Exibir:</label></td>
                            <td>
                                <select name="txtExibir">
                                    <option value="0" <c:if test="${prato.exibir == 0}"> selected</c:if>>Não</option>
                                <option value="1" <c:if test="${prato.exibir == 1}"> selected</c:if>>Sim</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="btnIncluir" value="Confirmar">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <script>
            function campoNumerico(valor){
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                    for (i = 0; i < valor.length && ehNumero == true; i++){
                        umCaracter = valor.charAt(i);
                        if (caracteresValidos.indexOf(umCaracter) == - 1){
                        ehNumero = false;
                        }
                    }
                return ehNumero;
            }
            function validarFormulario(form) {
                var mensagem;
                mensagem = ""; 
                
            if (form.txtIdFuncionario.value === "0") {
            mensagem = mensagem + "Informe o Código do Funcionário\n";
            }
            if (form.txtIdEstabelecimento.value === "0") {
            mensagem = mensagem + "Informe o Código do Estabelecimento\n";
            }
            if (form.txtId.value === "") {
            mensagem = mensagem + "Informe o Código do Prato\n";
            }
            if (form.txtNome.value === "") {
            mensagem = mensagem + "Informe o Nome do Prato\n";
            }
            if (form.txtDescricao.value === "") {
            mensagem = mensagem + "Informe a Descrição do Prato\n";
            }
            var antes;
            var depois;
            if (form.txtPreco.value === "") {
            mensagem = mensagem + "Informe o Preço do Prato\n";
            } else{
                antes = form.txtPreco.value;
                depois = antes.replace(",", ".");
                form.txtPreco.value = depois;
            }
            if (form.txtDataCriacao.value === "") {
            mensagem = mensagem + "Informe a Data da Criação do Prato\n";
            }
            if (form.txtExibir.value === "") {
            mensagem = mensagem + "Informe se quer esse Prato exibindo no Estabelecimento\n";
            }
            if (!campoNumerico(form.txtId.value)) {
            mensagem = mensagem + "Código do Prato deve ser numérico\n";
            }
            if (mensagem === "") {
            return true;
            } else {
            alert(mensagem);
               return false;
            }
        }
        </script>
    </body>
</html>
