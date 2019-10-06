<%-- 
    Document   : cadastroComanda
    Created on : 06/10/2019, 10:19:50
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Comanda</title>
    </head>
    <body>
        <h1>Comanda - ${operacao}</h1>
        <form action="ManterUsuarioController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterUsuario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" name="txtId" id="idComanda" value="${comanda.id}"/></td>
                        </tr>
                        <tr>
                            <td><label for="dataComanda">Data:</label></td>
                            <td><input type="date" name="txtDataComanda" id="dataComanda" value="${comanda.data}"/></td>
                        </tr>
                        <tr>
                            <td><label for="horaComanda">Hora:</label></td>
                            <td><input type="time" name="txtHoraComanda" id="horaComanda" value="${comanda.hora}"/></td>
                        </tr>
                        <tr>
                            <td><label for="idCliente">Id do Cliente:</label></td>
                            <td><input type="text" id="idCliente" name="txtIdCliente" value="${comanda.idCliente}"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <form action="ManterComandaController?acao=prepararOperacao&operacao=Incluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
    </body>
</html>
