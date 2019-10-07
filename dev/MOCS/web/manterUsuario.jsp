<%-- 
    Document   : manterUsuario
    Created on : 07/10/2019, 09:19:13
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Usuario</title>
    </head>
    <body>
        <h1>Manter Usuario - ${operacao}</h1>
        <form action="ManterUsuarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterUsuario">
            <table>
                <tr>
                    <td>Id do Usuario:</td>
                    <td><input type="text" name="txtId" value="${usuario.id}"/></td>
                </tr>
                <tr>
                    <td>Nome do Usuario:</td>
                    <td><input type="text" name="txtNome" value="${usuario.nome}"/></td>
                </tr>
                <tr>
                    <td>Sobrenome do Usuario:</td>
                    <td><input type="text" name="txtSobrenome" value="${usuario.sobrenome}"/></td>
                </tr>
                <tr>
                    <td>CPF:</td>
                    <td><input type="text" name="txtCpf" value="${usuario.cpf}"/></td>
                </tr>
                <tr>
                    <td>Data de Nascimento:</td>
                    <td><input type="date" name="txtDataNascimento" value="${usuario.dataNascimento}"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" placeholder="exemplo@email.com" name="txtEmail" value="${usuario.email}"/></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="phone" placeholder="(xx) x xxxx-xxxx" name="txtTelefone" value="${usuario.telefone}"/></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input type="password" name="txtSenha" value="${usuario.senha}"></td>
                </tr>
                <tr>
                    <td>Repita a senha:</td>
                    <td><input type="password" name="txtSenha" value="${usuario.senha}"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
