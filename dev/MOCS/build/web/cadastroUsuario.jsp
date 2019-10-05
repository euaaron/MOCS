<%-- 
    Document   : usuario
    Created on : 05/09/2019, 09:21:37
    Author     : Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuario</title>
    </head>
    <body>
        <div>
            <h1>Usuário - ${operacao}</h1>
        </div>        
        <div>
            <form action="ManterUsuarioController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterUsuario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" name="txtId" id="idUsuario" value="${usuario.id}"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" value="${usuario.nome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="sobrenome">Sobrenome:</label></td>
                            <td><input type="text" name="txtSobrenome" id="sobrenome" value="${usuario.sobrenome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td><input type="text" name="txtCpf" id="cpf" value="${usuario.cpf}"/></td>
                        </tr>
                        <tr>
                            <td><label for="dataNasc">Data de Nascimento:</label></td>
                            <td><input type="date" name="txtDataNascimento" id="dataNascimento" value="${usuario.dataNascimento}"/></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="email" id="email" placeholder="exemplo@email.com" name="txtEmail" value="${usuario.email}"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="phone" id="telefone" placeholder="(xx) x xxxx-xxxx" name="txtTelefone" value="${usuario.telefone}"/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="password" id="senha" name="txtSenha" value="${usuario.senha}"></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Repita a senha:</label></td>
                            <td><input type="password" id="confirmaSenha" name="txtSenha" value="${usuario.senha}"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <form action="ManterUsuarioController?acao=prepararOperacao&operacao=Incluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>