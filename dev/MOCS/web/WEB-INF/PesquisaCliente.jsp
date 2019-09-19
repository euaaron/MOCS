<%-- 
    Document   : PesquisaCliente
    Created on : 19/09/2019, 09:12:57
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Clientes</title>
    </head>
    <body>
        <h1>Pesquisa Clientes</h1>
        <table border = 1>
            <tr>
                <th>Código Cliente</th>
                <th>Nome Cliente</th>
            </tr>
            
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.codCliente}"/></td>
                    <td><c:out value="${cliente.nome}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
