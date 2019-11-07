<%-- 
    Document   : cadastroPedido
    Created on : 04/10/2019, 17:24:39
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${operacao} Pedido</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>${operacao} Pedido</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li><a href="PesquisarPedidoController">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <div>
            <form action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterPedido" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="idPedido">Id:</label></td>
                            <td><input type="text" name="txtId" id="idPedido" value="${pedido.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="idPrato">Prato:</label></td>
                            <td>
                                <select name="txtIdPrato" >
                                    <option value="0" <c:if test="${pedido.idPrato == null}"> selected</c:if>> </option>
                                    <c:forEach items="${pratos}" var="prato">
                                        <option value="${prato.id}" <c:if test="${pedido.idPrato == prato.id}"> selected</c:if>>${prato.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="quantidade">Quantidade:</label></td>
                            <td><input type="text" name="txtQuantidade" id="quantidade" value="${pedido.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="idComanda">Id Comanda:</label></td>
                            <td><input type="text" name="txtIdComanda" id="idComanda"  value="${pedido.idComanda}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" name="btnIncluir" value="Confirmar">
                            </td>
                        </tr>
                    </tbody>
                </table>
        </div>
    </body>
</html>
