<%-- 
    Document   : pesquisaPrato
    Created on : 02/10/2019, 13:25:31
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Pratos</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>Pesquisar Pratos</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li>Pesquisar Pratos</li>
        </ul>
        <table border = 1>
            <tr>
                <th>Código do Prato</th>
                <th>Nome do Prato</th>
                <th>Codigo do Funcionario</th>
                <th>Codigo do Estabelecimento</th>
                <th>Data da criação</th>
            </tr>
            
            <c:forEach items="${pratos}" var="prato">
                <tr>
                    <td><c:out value="${prato.id}"/></td>
                    <td><c:out value="${prato.nome}"/></td>
                    <td><c:out value="${prato.idFuncionario}"/></td>
                    <td><c:out value="${prato.idEstabelecimento}"/></td>
                    <td><c:out value="${prato.dataCriacao}"/></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPratoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
