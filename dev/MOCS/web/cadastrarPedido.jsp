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
        <%-- Estilos, scripts e dependências de terceiros --%>
        <link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css"/>
        <script src="vendor/jquery-3.3.1.slim.min.js"></script>
        <script src="vendor/popper.min.js"></script>
        <script src="vendor/bootstrap/bootstrap.min.js"></script>
        <%-- Estilos e scripts próprios --%>
        <link rel="stylesheet" href="./css/main.css"/>
        <script src="./js/filtros.js"></script>
    </head>
    <body>
        <h1>${operacao} Pedido</h1>
        <ul class="breadcrumb">
            <li><a href="inicio.jsp">Index Admin</a></li>
            <li><a href="PesquisarPedidoController">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <div>
            <form id="incluir" action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterPedido" method="post" onsubmit="return validarFormulario(this)">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="idPedido">Id:</label></td>
                            <td><input type="text" name="txtId" id="idPedido" maxlength="10" value="${pedido.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="idComanda">Id Comanda:</label></td>
                            <td><input type="text" maxlength="10" name="txtIdComanda" id="idComanda"  value="${pedido.idComanda}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="idPrato">Prato:</label></td>
                            <td>
                                <select id="idPrato" name="txtIdPrato" >
                                    <option value="0" <c:if test="${pedido.idPrato == null}"> selected</c:if>> </option>
                                    <c:forEach items="${pratos}" var="prato">
                                        <option value="${prato.id}" <c:if test="${pedido.idPrato == prato.id}"> selected</c:if>>${prato.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="quantidade">Quantidade:</label></td>
                            <td><input type="number" name="txtQuantidade" id="quantidade" min="1" value="${pedido.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="idComanda">Comanda:</label></td>
                            <td>
                                <select id="idComanda" name="txtIdComanda" >
                                    <option value="0" <c:if test="${pedido.idComanda == null}"> selected</c:if>> </option>
                                    <c:forEach items="${comandas}" var="comanda">
                                        <option value="${comanda.id}" <c:if test="${pedido.idComanda == comanda.id}"> selected</c:if>>${comanda.id}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" name="btnIncluir" value="Confirmar">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <script>
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == - 1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtId.value === "") {
                    mensagem = mensagem + "Informe o Código do Pedido\n";
                }
                if (form.txtIdPrato.value === "0") {
                    mensagem = mensagem + "Informe o Prato\n";
                }
                if (form.txtQuantidade.value === "") {
                    mensagem = mensagem + "Informe a Quantidade\n";
                }
                if (form.txtIdComanda.value === "0") {
                    mensagem = mensagem + "Informe a Comanda\n";
                }
                if (!campoNumerico(form.txtId.value)) {
                    mensagem = mensagem + "Código do Pedido deve ser numérico\n";
                }
                if (!campoNumerico(form.txtQuantidade.value)) {
                    mensagem = mensagem + "A quantidade deve ser numérico e inteiro\n";
                }
                if (mensagem === "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
        </script>
    </body>
</html>
