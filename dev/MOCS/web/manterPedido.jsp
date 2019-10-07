<%-- 
    Document   : manterPedido
    Created on : 07/10/2019, 09:06:52
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Pedido</title>
    </head>
    <body>
        <h1>Manter Pedido - ${operacao}</h1>
        <form action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterPedido">
            <table>
                <tr>
                    <td>Id do Pedido:</td>
                    <td><input type="text" name="txtId" value="${pedido.id}"/></td>
                </tr>
                <tr>
                    <td>Id Prato:</td>
                    <td><input type="text" name="txtIdPrato" value="${pedido.idPrato}"/></td>
                </tr>
                <tr>
                    <td>Quantidade:</td>
                    <td><input type="number" min="0" placeholder="1" name="txtQuantidade" value="${pedido.quantidade}"/></td>
                </tr>
                <tr>
                    <td>Id Comanda:</td>
                    <td><input type="text" name="txtIdComanda" value="${pedido.idComanda}"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
