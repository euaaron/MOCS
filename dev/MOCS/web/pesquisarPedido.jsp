<%-- 
    Document   : pesquisaPedido
    Created on : 02/10/2019, 13:49:11
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Pedidos</title>
    </head>
    <body>
        <h1>Pesquisa de Pedidos</h1>
        <table>
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
