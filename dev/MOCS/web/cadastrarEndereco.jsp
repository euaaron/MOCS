<%-- 
    Document   : cadastroEndereco
    Created on : 26/09/2019, 09:51:38
    Author     : Aaron Stiebler e Débora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Endereco</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <div>
            <h1>Endereco - ${operacao}</h1>
        </div>        
        <div>
            <form action="ManterEnderecoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterEndereco" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" id="idEndereco" maxlength="10" name="txtId" value="${endereco.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="cep">CEP:</label></td>
                            <td><input type="text" id="cep" name="txtCEP" maxlength="10" value="${endereco.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="uf">UF:</label></td>
                            <td><input type="text" id="uf" name="txtUF" maxlength="4" value="${endereco.UF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="cidade">Cidade:</label></td>
                            <td><input type="text" id="cidade" name="txtCidade" maxlength="45" value="${endereco.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="bairro">Bairro:</label></td>
                            <td><input type="text" id="bairro" name="txtBairro" maxlength="45" value="${usuario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="logradouro">Logradouro:</label></td>
                            <td><input type="text" id="logradouro" maxlength="45" name="txtLogradouro" value="${usuario.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="complemento">Complemento:</label></td>
                            <td><input type="text" id="complemento" maxlength="30" name="txtComplemento:" value="${usuario.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
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
