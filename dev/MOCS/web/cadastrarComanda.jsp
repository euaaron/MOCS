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
        <%-- Estilos, scripts e dependências de terceiros --%>
        <link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css"/>
        <script src="vendor/jquery-3.3.1.slim.min.js"></script>
        <script src="vendor/popper.min.js"></script>
        <script src="vendor/bootstrap/bootstrap.min.js"></script>
        <script src="vendor/fontawesome/js/all.min.js"></script>
        <%-- Estilos e scripts próprios --%>
        <link rel="stylesheet" href="./css/main.css"/>
        <script src="./js/filtros.js"></script>
    </head>
    <body>
        <h1>${operacao} Comanda</h1>
        <ul class="breadcrumb">
            <li><a href="inicio">Index Admin</a></li>
            <li><a href="PesquisarComandaController">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <form id="incluir" action="ManterComandaController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterUsuario" method="post" onsubmit="return validarFormulario(this)">
            <table border="1">
                <tbody>
                    <tr>
                        <td><label for="idComanda">Id:</label></td>
                        <td><input type="text" name="txtId" id="idComanda" maxlength="10" value="${comanda.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="idCliente">Cliente</label></td>
                            <td>
                                <select id="idCliente" name="txtIdCliente" <c:if test="${operacao == 'Excluir'}"> </c:if>>
                                <option value="0" <c:if test="${comanda.idCliente == null}"> selected</c:if>> </option>  
                                <c:forEach items="${clientes}" var="cliente">
                                    <option value="${cliente.id}" <c:if test="${cliente.id == comanda.idCliente}"> selected</c:if> >${cliente.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="dataComanda">Data:</label></td>
                        <td><input type="date" name="txtDataComanda" id="dataComanda" value="${comanda.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="horaComanda">Hora:</label></td>
                            <td><input type="time" name="txtHoraComanda" id="horaComanda" value="${comanda.hora}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" name="btnIncluir" value="Confirmar" <c:if test="${operacao == 'Excluir'}"> </c:if>>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
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
            }
            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
            if (form.txtId.value == "") {
            mensagem = mensagem + "Informe o Código da Comanda\n";
            }
            if (form.txtIdCliente.value == "0") {
            mensagem = mensagem + "Informe o Cliente\n";
            }
            if (form.txtDataComanda.value == "") {
            mensagem = mensagem + "Informe a data de abertura da comanda\n";
            }
            if (form.txtHoraComanda.value == "") {
            mensagem = mensagem + "Informe a hora de abertura da comanda\n";
            }
            if (!campoNumerico(form.txtId.value)) {
            mensagem = mensagem + "Código da Comanda deve ser numérico\n";
            }           
            if (mensagem == "") {
                return true;
            } else {
            alert(mensagem);
                return false;
            }
            }
        </script>
    </body>
</html>