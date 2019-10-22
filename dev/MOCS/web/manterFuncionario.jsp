<%-- 
    Document   : manterFuncionario
    Created on : 02/10/2019, 11:16:53
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                    <td>Id do Funcionario:</td>
                    <td><input type="text" name="txtIdFuncionario" value="${funcionario.id}"></td>
                </tr>
                <tr>
                    <td>Id do Estabelecimento:</td>
                    <td><input type="text" name="txtIdEstabelecimento" value="${funcionario.idEstabelecimento}"/></td>
                </tr>
                <tr>
                    <td>Nome do Funcionario:</td>
                    <td><input type="text" name="txtNome" value="${funcionario.nome}"></td>
                </tr>
                <tr>
                    <td>CPF:</td>
                    <td><input type="text" name="txtCpf" value="${funcionario.cpf}"></td>
                </tr>
                <tr>
                    <td>Data de Nascimento:</td>
                    <td><input type="text" name="txtDataNascimento" value="${funcionario.dataNascimento}"></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" name="txtEmail" value="${funcionario.email}"></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="txtTelefone" value="${funcionario.telefone}"></td>
                </tr>
                <tr>
                    <td>Id da Função:</td>
                    <td><input type="text" name="txtIdFuncao" value="${funcionario.idFuncao}"></td>
                </tr>
                <tr>
                    <td>Status da Conta:</td>
                    <td><input type="text" name="txtStatusConta" value="${funcionario.statusConta}"></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input type="text" name="txtSenha" value="${funcionario.senha}"></td>
                </tr>
                <tr>
                    <td>Repita a senha:</td>
                    <td><input type="text" name="txtSenha" id="confirmaSenha" value="${funcionario.senha}"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
