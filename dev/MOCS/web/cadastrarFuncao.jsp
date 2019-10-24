<%-- 
    Document   : cadastrarFuncao
    Created on : 24/10/2019, 10:15:46
    Author     : euaar
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
            <form action="ManterFuncaoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterFuncao" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="idFuncao">Id:</label></td>
                            <td><input type="text" name="txtIdFuncao" id="idFuncao" value="${funcao.idFuncao}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idEstabelecimento">Id do Estabelecimento:</label></td>
                            <td><input type="text" name="txtIdEstabelecimento" id="idEstabelecimento" value="${funcao.idEstabelecimento}"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" value="${funcao.nome}"/></td>
                        </tr>
                        <tr>
                            <td><label for="decricao">CPF:</label></td>
                            <td><input type="text" name="txtDecricao" id="decricao" value="${funcao.decricao}"/></td>
                        </tr>
                        <tr>
                            <td><label for="nivelPermissao">Data de Nascimento:</label></td>
                            <td><input type="text" name="txtNivelPermissao" id="nivelPermissao" value="${funcao.nivelPermissao}"/></td>
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
