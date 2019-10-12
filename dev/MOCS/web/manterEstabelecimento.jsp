<%-- 
    Document   : manterEstabelecimento
    Created on : 07/10/2019, 08:54:24
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Estabelecimento</title>
    </head>
    <body>
        <h1>Manter Estabelecimento - ${operacao}</h1>
        <form action="ManterEstabelecimentoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEstabelecimento">
            <table>
                <tr>
                    <td>Id do Estabelecimento:</td>
                    <td><input type="text" name="txtIdEstabelecimento" value="${estabelecimento.id}"></td>
                </tr>
                <tr>
                    <td>Id do Proprietario:</td>
                    <td><input type="text" name="txtIdProprietario" value="${estabelecimento.idProprietario}"></td>
                </tr>
                <tr>
                    <td>CNPJ:</td>
                    <td><input type="text" name="txtCnpj" value="${estabelecimento.cnpj}"></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="txtTelefone" value="${estabelecimento.telefone}"></td>
                </tr>
                <tr>
                    <td>Nome Fantasia:</td>
                    <td><input type="text" name="txtNomeFantasia" value="${estabelecimento.nomeFantasia}"></td>
                </tr>
                <tr>
                    <td>Inscrição Estadual:</td>
                    <td><input type="text" name="txtInscEstadual" value="${estabelecimento.inscEstadual}"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnIncluir" value="Incluir"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
