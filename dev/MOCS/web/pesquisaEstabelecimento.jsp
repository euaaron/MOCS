<%-- 
    Document   : pesquisaEstabelecimento
    Created on : 19/09/2019, 09:13:42
    Author     : euaar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Estabelecimentos</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>Pesquisa Estabelecimentos</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li><a href="#">Estabelecimento</a></li>
            <li><a href="#">Procurar</a></li>
        </ul>
        <table border="1">
            <tr>
                <th>Codigo do Estabelecimento</th>
                <th>Nome do Estabelecimento</th>
                <th>Proprietario do Estabelecimento</th>
            </tr>
            <c:forEach items="${estabelecimentos}" var="estabelecimento">
        <tr>
            <td><c:out value="${estabelecimento.id}"/></td>
            <td><c:out value="${estabelecimento.nome}"/></td>
            <td><c:out value="${estabelecimento.proprietario}"/></td>
        </tr>
        </c:forEach>
        </table>
    </body>
</html>
