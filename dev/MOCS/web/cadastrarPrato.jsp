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
        <title>Cadastro de Prato</title>
    </head>
    <body>
        <h1>Prato - ${operacao}</h1>
        <form action="ManterPratoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterPrato" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" name="txtId" id="idPrato" value="${prato.id}"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" value="${prato.nome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="descricao">Descricao:</label></td>
                            <td><input type="text" name="txtDescricao" id="decricao" value="${prato.descricao}"/></td>
                        </tr>
                        <tr>
                            <td><label for="dataCriacao">Data da Criação:</label></td>
                            <td><input type="text" name="txtDataCriacao" id="dataCriacao" value="${prato.dataCriacao}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idFuncionario">Id do Funcionario:</label></td>
                            <td><input type="text" name="txtIdFuncionario" id="idFuncionario" value="${prato.IdFuncionario}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idEstabelecimento">Id do Estabelecimento:</label></td>
                            <td><input type="text" name="txtIdEstabelecimento" id="idEstabelecimento" value="${prato.idEstabelecimento}"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <form action="ManterPratoController?acao=prepararOperacao&operacao=Incluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
    </body>
</html>
