<%-- 
    Document   : pesquisaFuncionario
    Created on : 02/10/2019, 13:35:24
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Funcionarios</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>Pesquisar Funcionarios</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li>Pesquisar</li>
        </ul>
        <table border = 1>
            <tr>
                <th>Cod. Funcionario</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Status da Conta</th>
            </tr>
            
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td><c:out value="${funcionario.id}"/></td>
                    <td><c:out value="${funcionario.nome}"/></td>
                    <td><c:out value="${funcionario.getFuncao().getNome()}"/></td>
                    <td><c:out value="${funcionario.statusConta}"/></td>
                    <td>
                        <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${funcionario.id}" />" > Editar</a>
                    </td>
                    <td>
                        <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${funcionario.id}" />" > Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
