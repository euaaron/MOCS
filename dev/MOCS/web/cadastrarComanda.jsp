<%-- 
    Document   : cadastroComanda
    Created on : 06/10/2019, 10:19:50
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <title>${operacao} Comanda</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>${operacao} Comanda</h1>
        <ul class="breadcrumb">
                <li><a href="index.jsp">Index Admin</a></li>
                <li><a href="PesquisarComandaController">Pesquisar</a></li>
                <li>${operacao}</li>
            </ul>
        <form action="ManterComandaController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterUsuario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" name="txtId" maxlength="10" id="idComanda" value="${comanda.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="idCliente">Id do Cliente:</label></td>
                            <td><input type="text" id="idCliente" maxlength="10" name="txtIdCliente" value="${comanda.idCliente}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="dataComanda">Data:</label></td>
                            <td><input type="text" name="txtDataComanda" maxlength="10" id="dataComanda" value="${comanda.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="horaComanda">Hora:</label></td>
                            <td><input type="text" name="txtHoraComanda" maxlength="5" id="horaComanda" value="${comanda.hora}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" name="btnIncluir" value="Confirmar">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
    </body>
</html>