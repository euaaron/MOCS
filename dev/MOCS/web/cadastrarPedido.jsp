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
        <title>MOCS</title>
    </head>
    <body>
        <h1>Pedido - ${operacao}</h1>
        <div>
            <form action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterPedido" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" name="txtId" id="idPedido" value="${pedido.id}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idPrato">Id Prato:</label></td>
                            <td><input type="text" name="txtIdPrato" id="idPrato" value="${pedido.idPrato}"/></td>
                        </tr>
                        <tr>
                            <td><label for="quantidade">Quantidade:</label></td>
                            <td><input type="text" id="quantidade" min="0" placeholder="1" name="txtQuantidade" value="${pedido.quantidade}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idComanda">Id Comanda:</label></td>
                            <td><input type="text" id="idComanda" name="txtIdComanda" value="${pedido.idComanda}"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <form action="ManterPedidoController?acao=prepararOperacao&operacao=Incluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>
