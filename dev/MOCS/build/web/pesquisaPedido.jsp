<%-- 
    Document   : pesquisaPedido
    Created on : 02/10/2019, 13:49:11
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Pedido</title>
    </head>
    <body>
        <h1>Pesquisa Pedido</h1>
        <table border = 1>
            <tr>
                <th>Código do Pedido</th>
                <th>Código da Comanda</th>
                <th>Código do Prato</th>
                <th>Quantidade do Prato</th>
            </tr>
            
            <c:forEach items="${pratos}" var="prato">
                <tr>
                    <td><c:out value="${prato.id}"/></td>
                    <td><c:out value="${prato.idComanda}"/></td>
                    <td><c:out value="${prato.idPrato}"/></td>
                    <td><c:out value="${prato.quantidade}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
