<%-- 
    Document   : manterProprietario
    Created on : 07/10/2019, 09:18:05
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Proprietario</title>
    </head>
    <body>
        <h1>Manter Proprietario - ${operacao}</h1>
        <form action="ManterProprietarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterProprietario">
            <table>
                <tr>
                    <td>Id do Proprietario:</td>
                    <td><input type="text" name="txtId" value="${proprietario.id}"/></td>
                </tr>
                <tr>
                    <td>Nome do Proprietario:</td>
                    <td><input type="text" name="txtNome" value="${proprietario.nome}"/></td>
                </tr>
                <tr>
                    <td>CPF:</td>
                    <td><input type="text" name="txtCpf" value="${proprietario.cpf}"/></td>
                </tr>
                <tr>
                    <td>Data de Nascimento:</td>
                    <td><input type="text" name="txtDataNascimento" value="${proprietario.dataNascimento}"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" placeholder="exemplo@email.com" name="txtEmail" value="${proprietario.email}"/></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" placeholder="(xx) x xxxx-xxxx" name="txtTelefone" value="${proprietario.telefone}"/></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input type="text" name="txtSenha" value="${proprietario.senha}"></td>
                </tr>
                <tr>
                    <td>Repita a senha:</td>
                    <td><input type="text" name="txtSenha" value="${proprietario.senha}"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
