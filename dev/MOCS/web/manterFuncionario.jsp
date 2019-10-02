<%-- 
    Document   : manterFuncionario
    Created on : 02/10/2019, 11:16:53
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Funcionario</title>
    </head>
    <body>
        <h1>Manter Funcionario - ${operacao}</h1>
        <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario">
            <table>
                <tr>
                    <td>Código do Funcionario:</td>
                    <td><input type="text" name="txtIdUsuario" value="${funcionario.idUsuario}"></td>
                </tr>
                <tr>
                    <td>Nome do Funcionario:</td>
                    <td><input type="text" name="txtNomeUsuario" value="${funcionario.nome}"></td>
                </tr>
                <tr>
                    <td>Sobrenome do Funcionario:</td>
                    <td><input type="text" name="txtSobrenomeUsuario" value="${funcionario.sobrenome}"></td>
                </tr>
                <tr>
                    <td>Data de Nascimento:</td>
                    <td><input type="text" name="txtDataNascUsuario" value="${funcionario.dataNascimento}"></td>
                </tr>
                <tr>
                    <td>Cpf:</td>
                    <td><input type="text" name="txtCpfUsuario" value="${funcionario.cpf}"></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" name="txtEmailUsuario" value="${funcionario.email}"></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="txtTelefoneUsuario" value="${funcionario.telefone}"></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input type="text" name="txtSenhaUsuario" value="${funcionario.senha}"></td>
                </tr>
                <tr>
                    <td>Codigo do Estabelecimento:</td>
                    <td><input type="text" name="txtEstabelecimentoUsuario" value="${funcionario.idEstabelecimento}"></td>
                </tr>
                <tr>
                    <td>Codigo da Função:</td>
                    <td><input type="text" name="txtFuncaoUsuario" value="${funcionario.idFuncao}"></td>
                </tr>
                <tr>
                    <td>Status da Conta:</td>
                    <td><input type="text" name="txtStatusUsuario" value="${funcionario.statusConta}"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
