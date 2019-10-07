<%-- 
    Document   : manterPrato
    Created on : 07/10/2019, 09:17:31
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Prato</title>
    </head>
    <body>
        <h1>Manter Prato - ${operacao}</h1>
        <form action="ManterPratoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterPrato">
            <table>
                <tr>
                    <td>Id do Prato:</td>
                    <td><input type="text" name="txtId" value="${prato.id}"/></td>
                </tr>
                <tr>
                    <td>Nome do Prato:</td>
                    <td><input type="text" name="txtNome" value="${prato.nome}"/></td>
                </tr>
                <tr>
                    <td>Descrição do Prato:</td>
                    <td><input type="text" name="txtDescricao" value="${prato.descricao}"/></td>
                </tr>
                <tr>
                    <td>Id do Funcionário:</td>
                    <td><input type="text" name="txtIdFuncionario" value="${prato.IdFuncionario}"/></td>
                </tr>
                <tr>
                    <td>Id do Estabelecimento:</td>
                    <td><input type="text" name="txtIdEstabelecimento" value="${prato.idEstabelecimento}"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
