<%-- 
    Document   : manterComanda
    Created on : 07/10/2019, 08:42:47
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Comanda</title>
    </head>
    <body>
        <h1>Manter Comanda - ${operacao}</h1>
        <form action="ManterComandaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterComanda">
            <table>
                <tr>
                    <td>Id da Comanda:</td>
                    <td><input type="text" name="txtId" value="${comanda.id}"/></td>
                </tr>
                <tr>
                    <td>Data:</td>
                    <td><input type="date" name="txtDataComanda" value="${comanda.data}"/></td>
                </tr>
                <tr>
                    <td>Hora:</td>
                    <td><input type="time" name="txtHoraComanda" value="${comanda.hora}"/></td>
                </tr>
                <tr>
                    <td>Id do Cliente:</td>
                    <td><input type="text" name="txtIdCliente" value="${comanda.idCliente}"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
