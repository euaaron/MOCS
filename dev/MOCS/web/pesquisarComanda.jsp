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
        <title>Pesquisar Comandas</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>Pesquisar Comandas</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li>Pesquisar</li>
        </ul>
        <table border = 1>
            <tr>
                <th colspan="2">OPÇÕES</th>
                <th>COD</th>
                <th>DATA</th>
                <th>HORA</th>
                <th>CLIENTE</th>
                <th>TOTAL</th>
                <th colspan="2">PEDIDOS</th>
            </tr>
            
            <c:forEach items="${comandas}" var="comanda">
                <tr>
                    <td>
                        <a href="ManterComandaController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${comanda.id}" />" > Editar</a>
                    </td>
                    <td>
                        <a href="ManterComandaController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${comanda.id}" />" > Excluir</a>
                    </td>
                    <td><c:out value="${comanda.id}"/></td>
                    <td><c:out value="${comanda.data}"/></td>
                    <td><c:out value="${comanda.hora}"/></td>
                    <td><c:out value="${comanda.cliente.nome}"/></td>
                    <td>R$ <fmt:formatNumber type="number" minFractionDigits="2" value="${comanda.obterTotal()}"/></td>
                    <c:forEach items="${pedidos}" var="pedido">                                    
                    <td>
                        <c:if test="${pedido.comanda.id == comanda.id}">[${pedido.quantidade} unid.] ${pedido.prato.nome} [R$ <fmt:formatNumber type="number" minFractionDigits="2" value="${pedido.prato.preco * pedido.quantidade}"/>] </c:if>
                    </td>
                    </c:forEach>
                    <td>
                        <a href="ManterPedidoController?acao=prepararOperacao&operacao=Incluir&id=<c:out value="${comanda.id}" />" > Incluir Pedido</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterComandaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
