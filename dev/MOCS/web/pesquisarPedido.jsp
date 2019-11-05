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
        <title>Pesquisar Pedidos</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>Pesquisar Pedidos</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li>Pesquisar</li>
        </ul>
        <table border = 1>
            <tr>
                <th>COD</th>
                <th>DIA</th>
                <th>CLIENTE</th>
                <th>PRATO</th>
                <th>QUANTIDADE</th>
                <th colspan="2">OPÇÕES</th>
            </tr>
            
            <c:forEach items="${pedidos}" var="pedido">
                <tr>
                    <td><c:out value="${pedido.id}"/>/<c:out value="${pedido.comanda.id}"/></td>
                    <td><c:out value="${pedido.comanda.data}"/></td>
                    <td><c:out value="${pedido.comanda.cliente.nome}"/></td>
                    <td><c:out value="${pedido.prato.nome}"/></td>
                    <td><c:out value="${pedido.quantidade}"/></td>
                    <td>
                        <a href="ManterPedidoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${pedido.id}" />" > Editar</a>
                    </td>
                    <td>
                        <a href="ManterPedidoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${pedido.id}" />" > Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPedidoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
