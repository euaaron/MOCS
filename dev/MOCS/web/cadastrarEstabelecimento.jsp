<%-- 
    Document   : Estabelecimento
    Created on : 05/09/2019, 09:22:06
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Estabelecimento</title>
    </head>
    <body>
        <h1>Estabelecimento - ${operacao}</h1>
        <form action="ManterEstabelecimentoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterEstabelecimento" method="post">
        <table>
                <tr>
                    <td><label for="id">Id:</label></td>
                    <td><input type="text" name="txtIdEstabelecimento" id="idEstabelecimento" value="${estabelecimento.id}"></td>
                </tr>
                <tr>
                    <td><label for="idProprietario">Id do Proprietario:</label></td>
                    <td><input type="text" name="txtIdProprietario" id="idProprietario" value="${estabelecimento.idProprietario}"></td>
                </tr>
                <tr>
                    <td><label for="cnpj">CNPJ:</label></td> <!-- Número do CNPJ -->
                    <td><input type="text" name="txtCnpj" id="cnpj" value="${estabelecimento.cnpj}"></td>
                </tr>
                <tr>
                    <td><label for="telefone">Telefone:</label></td> <!-- Número de telefone. -->
                    <td><input type="text" name="txtTelefone" id="telefone" value="${estabelecimento.telefone}"></td>
                </tr>
                <tr>
                    <td><label for="nomeFantasia">Nome Fantasia:</label></td> <!-- Nome Fantasia Completo da Empresa -->
                    <td><input type="text" name="txtNomeFantasia" id="nomeFantasia" value="${estabelecimento.nomeFantasia}"></td>
                </tr>
                <tr>
                    <td><label for="inscEstadual">Inscrição Estadual:</label></td> <!-- Número da inscrição estadual da empresa -->
                    <td><input type="text" name="txtInscEstadual" id="inscEstadual" value="${estabelecimento.inscEstadual}"></td>
                </tr>
                <tr>
                    <td><label for="idEndereco">Id do Endereco</label></td>
                    <td><input type="text" name="txtIdEndereco" id="idEndereco" value="${estabelecimento.idEndereco}"></td>
                </tr>
                <tr>
                    <td><label for="cnpj">CNPJ:</label></td> <!-- Número do CNPJ -->
                    <td><input type="text" name="txtCnpj" id="cnpj" value="${estabelecimento.cnpj}"></td>
                </tr>
                <tr>
                    <td><label for="telefone">Telefone:</label></td> <!-- Número de telefone. -->
                    <td><input type="text" name="txtTelefone" id="telefone" value="${estabelecimento.telefone}"></td>
                </tr>
                <tr>
                    <td><label for="nomeFantasia">Nome Fantasia:</label></td> <!-- Nome Fantasia Completo da Empresa -->
                    <td><input type="text" name="txtNomeFantasia" id="nomeFantasia" value="${estabelecimento.nomeFantasia}"></td>
                </tr>
                <tr>
                    <td><label for="inscEstadual">Inscrição Estadual:</label></td> <!-- Número da inscrição estadual da empresa -->
                    <td><input type="text" name="txtInscEstadual" id="inscEstadual" value="${estabelecimento.inscEstadual}"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnIncluir" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
