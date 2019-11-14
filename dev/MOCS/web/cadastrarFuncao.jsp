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
        <link rel="stylesheet" href="css/main.css"/>
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
            <form action="ManterFuncaoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterFuncao" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="idEstabelecimento">Id do Estabelecimento:</label></td>
                            <td><input type="text" name="txtIdEstabelecimento" maxlength="10" id="idEstabelecimento" value="${funcao.idEstabelecimento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="id">Id da Funcao:</label></td>
                            <td><input type="text" name="txtIdFuncao" maxlength="10" id="id" value="${funcao.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" maxlength="45" id="nome" value="${funcao.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="descricao">Descrição:</label></td>
                            <td><input type="text" maxlength="60" name="txtDescricao" id="decricao" value="${funcao.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="nivelPermissao">Nível de Permissão:</label></td>
                            <td><input type="text" maxlength="10" name="txtNivelPermissao" id="nivelPermissao" value="${funcao.nivelPermissao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
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
    </body>
</html>
