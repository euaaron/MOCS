<%-- 
    Document   : cadastrarFuncao
    Created on : 24/10/2019, 10:15:46
    Author     : euaar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${operacao} Funcao</title>
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
        <div>
            <h1>${operacao} Funcao</h1>
            <ul class="breadcrumb">
                <li><a href="index.jsp">Index Admin</a></li>
                <li><a href="PesquisarFuncaoController">Pesquisar</a></li>
                <li>${operacao}</li>
            </ul>
        </div>        
        <div>
            <form id="incluir" action="ManterFuncaoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterFuncao" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="idEstabelecimento">Id do Estabelecimento:</label></td>
                            <td><input type="text" name="txtIdEstabelecimento" id="idEstabelecimento" maxlength="10" value="${funcao.idEstabelecimento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="id">Id da Funcao:</label></td>
                            <td><input type="text" name="txtIdFuncao" id="id" maxlength="10" value="${funcao.id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" maxlength="45" value="${funcao.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="descricao">Descrição:</label></td>
                            <td><input type="text" name="txtDescricao" id="descricao" maxlength="60" value="${funcao.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="nivelPermissao">Nível de Permissão:</label></td>
                            <td><input type="number" name="txtNivelPermissao" id="nivelPermissao" max="5" value="${funcao.nivelPermissao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" name="btnIncluir" value="Confirmar">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <script>
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == - 1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            document.getElementById("incluir").addEventListener("submit", () =>
            {
                let form = document.getElementById("incluir");
                let mensagem;
                mensagem = "";
                if (form.txtId.value === "") {
                    mensagem = mensagem + "Informe o Código da Comanda\n";
                }
                if (form.txtIdCliente.value === "") {
                    mensagem = mensagem + "Informe o Código do Cliente\n";
                }
                if (form.txtDataComanda.value === "") {
                    mensagem = mensagem + "Informe a data de abertura da comanda\n";
                }
                if (form.txtHoraComanda.value === "") {
                    mensagem = mensagem + "Informe a hora de abertura da comanda\n";
                }
                if (!campoNumerico(form.txtId.value)) {
                    mensagem = mensagem + "Código da Comanda deve ser numérico\n";
                }
                if (!campoNumerico(form.txtIdCliente.value)) {
                    mensagem = mensagem + "Código do Cliente deve ser numérico\n";
                }
                if (mensagem === "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            });
        </script>
    </body>
</html>
