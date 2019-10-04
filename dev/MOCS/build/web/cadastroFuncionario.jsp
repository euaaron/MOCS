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
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" value="${funcionario.nome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Email:</label></td>
                            <td><input type="email" id="email" placeholder="exemplo@email.com"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Celular:</label></td>
                            <td><input type="phone" id="tel" placeholder="(xx) x xxxx-xxxx"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Senha:</label></td>
                            <td><input type="password" id="senha" placeholder="Ex3mpl@"></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Repita a senha:</label></td>
                            <td><input type="password" id="confirmaSenha" placeholder="Ex3mpl@"></td>
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
