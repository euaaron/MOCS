<%-- 
    Document   : cadastroFuncionario
    Created on : 05/09/2019, 10:20:01
    Author     : Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionários</title>
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
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" name="txtId" id="idFuncionario" value="${funcionario.id}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idEstabelecimento">Id do Estabelecimento:</label></td>
                            <td><input type="text" name="txtIdEstabelecimento" id="idEstabelecimento" value="${funcionario.idEstabelecimento}"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" value="${funcionario.nome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="sobrenome">Sobrenome:</label></td>
                            <td><input type="text" name="txtSobrenome" id="sobrenome" value="${funcionario.sobrenome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td><input type="text" name="txtCpf" id="cpf" value="${funcionario.cpf}"/></td>
                        </tr>
                        <tr>
                            <td><label for="dataNasc">Data de Nascimento:</label></td>
                            <td><input type="date" name="txtDataNascimento" id="dataNascimento" value="${funcionario.dataNascimento}"/></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="email" id="email" placeholder="exemplo@email.com" value="${funcionario.email}"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="phone" id="telefone" placeholder="(xx) x xxxx-xxxx" name="txtTelefone" value="${funcionario.telefone}"/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="password" name="txtSenha" id="senha" value="${funcionario.senha}"></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Repita a senha:</label></td>
                            <td><input type="password" name="txtSenha" id="confirmaSenha" value="${funcionario.senha}"></td>
                        </tr>
                    </tbody>
                </table>
                <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
                    <input type="submit" name="btnIncluir" value="Incluir">                        
                </form>
            </form>
        </div>
    </body>
</html>
