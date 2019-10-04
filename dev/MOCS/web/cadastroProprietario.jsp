<%-- 
    Document   : cadastroProprietario
    Created on : 04/10/2019, 17:21:33
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Proprietario</title>
    </head>
    <body>
        <h1>Proprietario - ${operacao}</h1>
        <div>
            <form action="ManterProprietarioController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterProprietario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" name="txtId" id="idProprietario" value="${proprietario.id}"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" value="${proprietario.nome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="sobrenome">Sobrenome:</label></td>
                            <td><input type="text" name="txtsobrenome" id="sobrenome" value="${proprietario.sobrenome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td><input type="text" name="txtCpf" id="cpf" value="${proprietario.cpf}"/></td>
                        </tr>
                        <tr>
                            <td><label for="dataNasc">Data de Nascimento:</label></td>
                            <td><input type="date" name="txtDataNascimento" id="dataNascimento" value="${proprietario.dataNascimento}"/></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="email" id="email" placeholder="exemplo@email.com" name="txtEmail" value="${proprietario.email}"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="phone" id="telefone" placeholder="(xx) x xxxx-xxxx" name="txtTelefone" value="${proprietario.telefone}"/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="password" id="senha" name="txtSenha" value="${proprietario.senha}"></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Repita a senha:</label></td>
                            <td><input type="password" id="confirmaSenha" name="txtSenha" value="${proprietario.senha}"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <form action="ManterProprietarioController?acao=prepararOperacao&operacao=Incluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>
