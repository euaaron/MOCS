<%-- 
    Document   : PesquisaComanda
    Created on : 02/10/2019, 13:39:31
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Comandas</title>
    </head>
    <body>
        <h1>Pesquisa de Comandas</h1>
        <table border = 1>
            <tr>
                <th>Código da Comanda</th>
                <th>Data da Comanda</th>
                <th>Hora da Comanda</th>
                <th>Codigo do Cliente</th>
            </tr>
            
            <c:forEach items="${comandas}" var="comanda">
                <tr>
                    <td><c:out value="${comanda.id}"/></td>
                    <td><c:out value="${comanda.dataComanda}"/></td>
                    <td><c:out value="${comanda.horaComanda}"/></td>
                    <td><c:out value="${comanda.idCliente}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
