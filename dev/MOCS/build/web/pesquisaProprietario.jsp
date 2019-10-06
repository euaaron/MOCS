<%-- 
    Document   : pesquisaProprietario
    Created on : 03/10/2019, 16:16:01
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Proprietario</title>
    </head>
    <body>
        <h1>Pesquisa de Proprietario</h1>
        <table border = 1>
            <tr>
                <th>Código do Proprietario</th>
                <th>Nome do Proprietario</th>
                <th>Sobrenome do Proprietario</th>
            </tr>
            
            <c:forEach items="${proprietarios}" var="proprietario">
                <tr>
                    <td><c:out value="${proprietario.id}"/></td>
                    <td><c:out value="${proprietario.nome}"/></td>
                    <td><c:out value="${proprietario.sobrenome}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
