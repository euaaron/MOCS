<%-- 
    Document   : cadastroFuncionario
    Created on : 05/09/2019, 10:20:01
    Author     : Aaron Stiebler & Débora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Funcionários</title>
    </head>
    <body>
        <div>
            <h1>Funcionario - ${operacao}</h1>
        </div>        
        <div>
            <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterFuncionario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="idEstabelecimento">Id do Estabelecimento:</label></td>
                            <td><input type="text" name="txtIdEstabelecimento" id="idEstabelecimento" value="${funcionario.idEstabelecimento}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idFuncionario">Id:</label></td>
                            <td><input type="text" name="txtIdFuncionario" id="idFuncionario" value="${funcionario.id}"/></td>
                        </tr>
                        <tr>
                            <td><label for="status">Status da Conta:</label></td>
                            <td><input type="text" name="txtStatusConta" id="statusConta" value="${funcionario.statusConta}"/></td>
                        </tr>                        
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" value="${funcionario.nome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td><input type="text" name="txtCpf" id="cpf" value="${funcionario.cpf}"/></td>
                        </tr>
                        <tr>
                            <td><label for="dataNasc">Data de Nascimento:</label></td>
                            <td><input type="text" name="txtDataNascimento" id="dataNascimento" value="${funcionario.dataNascimento}"/></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="text" id="email" placeholder="exemplo@email.com" value="${funcionario.email}"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="text" id="telefone" placeholder="(xx) x xxxx-xxxx" name="txtTelefone" value="${funcionario.telefone}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idFuncao">Id da Função:</label></td>
                            <td><input type="text" name="txtIdFuncao" id="idFuncao" value="${funcionario.idFuncao}"></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="text" name="txtSenha" id="senha" value="${funcionario.senha}"></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Repita a senha:</label></td>
                            <td><input type="text" name="txtSenha" id="confirmaSenha" value="${funcionario.senha}"></td>
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
