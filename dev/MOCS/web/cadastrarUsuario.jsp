<%-- 
    Document   : usuario
    Created on : 05/09/2019, 09:21:37
    Author     : Aaron Stiebler & Débora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${operacao} Usuário</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <div>
            <h1>${operacao} Usuário</h1>
        </div>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li><a href="PesquisarUsuarioController">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <div>
            <form action="ManterUsuarioController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterUsuario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" maxlength="10" name="txtIdUsuario" id="idUsuario" value="${usuario.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" maxlength="45" name="txtNome" id="nome" value="${usuario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td><input type="text" maxlength="14" name="txtCpf" id="cpf" value="${usuario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="dataNasc">Data de Nascimento:</label></td>
                            <td><input type="text" maxlength="10" name="txtDataNascimento" id="dataNascimento" value="${usuario.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="text" maxlength="45" id="email" placeholder="exemplo@email.com" name="txtEmail" value="${usuario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="text" maxlength="30" id="telefone" placeholder="(xx) x xxxx-xxxx" name="txtTelefone" value="${usuario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="text" maxlength="45" id="senha" name="txtSenha" value="${usuario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Repita a senha:</label></td>
                            <td><input type="text" maxlength="45" id="confirmaSenha" name="txtSenha" value="${usuario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
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
