<%-- 
    Document   : Estabelecimento
    Created on : 05/09/2019, 09:22:06
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${operacao} Estabelecimento</title>
        <script src="js/filtros.js"></script>
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
        <h1>${operacao} Estabelecimento</h1>
        <ul class="breadcrumb">
            <li><a href="inicio.jsp">Index Admin</a></li>
            <li><a href="PesquisarEstabelecimentoController">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <form id="incluir" action="ManterEstabelecimentoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterEstabelecimento" method="post" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td><label for="idEstabelecimento">Id:</label></td>
                    <td><input type="text" name="txtIdEstabelecimento" id="idEstabelecimento" maxlength="10" value="${estabelecimento.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for="idProprietario">Proprietario:</label></td>
                    <td>
                        <select id="idProprietario" name="txtIdProprietario" <c:if test="${operacao == 'Excluir'}"> </c:if>>
                            <option value="0" <c:if test="${estabelecimento.proprietario.id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${proprietarios}" var="proprietario">
                                <option value="${proprietario.id}" <c:if test="${proprietario.id == estabelecimento.proprietario.id}"> selected</c:if> >${proprietario.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="idEndereco">Id do Endereço:</label></td>
                    <td><input type="text" name="txtIdEndereco" maxlength="10" id="idEndereco" value="${endestabelecimento.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for="cnpj">CNPJ:</label></td> <!-- Número do CNPJ -->
                    <td><input type="text" name="txtCnpj" id="cnpj" placeholder="00.000.000/0000-00" maxlength="18" value="${estabelecimento.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="telefone">Telefone:</label></td> <!-- Número de telefone. -->
                    <td><input type="text" name="txtTelefone" id="telefone" maxlength="30" placeholder="(xx) xxxx-xxxx" value="${estabelecimento.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="nomeFantasia">Nome Fantasia:</label></td> <!-- Nome Fantasia Completo da Empresa -->
                    <td><input type="text" name="txtNomeFantasia" id="nomeFantasia" maxlength="45" value="${estabelecimento.nomeFantasia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="inscEstadual">Inscrição Estadual:</label></td> <!-- Número da inscrição estadual da empresa -->
                    <td><input type="text" name="txtInscEstadual" id="inscEstadual" maxlength="15" placeholder="000.000.000.000" value="${estabelecimento.inscEstadual}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="cep">CEP:</label></td>
                    <td><input type="text" id="cep" name="txtCEP" maxlength="10" placeholder="00.000-000" value="${endestabelecimento.cep}" onkeyup="filtraCEP()"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="uf">UF:</label></td>
                    <td><input type="text" id="uf" name="txtUF" maxlength="4" value="${endestabelecimento.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="cidade">Cidade:</label></td>
                    <td><input type="text" id="cidade" name="txtCidade" maxlength="45" value="${endestabelecimento.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="bairro">Bairro:</label></td>
                    <td><input type="text" id="bairro" name="txtBairro" maxlength="45" value="${endestabelecimento.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="logradouro">Logradouro:</label></td>
                    <td><input type="text" id="logradouro" name="txtLogradouro" maxlength="45" value="${endestabelecimento.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="edificio">Numero do Edificio:</label></td>
                    <td><input type="text" id="edificio" name="txtEdificio" maxlength="9" value="${endestabelecimento.numEdificio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="complemento">Complemento:</label></td>
                    <td><input type="text" id="complemento" name="txtComplemento" maxlength="30" value="${endestabelecimento.numComplemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnIncluir" value="Confirmar"></td>
                </tr>
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
                return ehNumero;
            }

            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtIdEstabelecimento.value === "") {
                    mensagem = mensagem + "Informe o Código do Estabelecimento\n";
                }
                if (form.txtIdProprietario.value === "0") {
                    mensagem = mensagem + "Informe o Código do Proprietário\n";
                }
                if (form.txtCnpj.value === "") {
                    mensagem = mensagem + "Informe o CNPJ do Estabelecimento\n";
                }
                if (form.txtNomeFantasia.value === "") {
                    mensagem = mensagem + "Informe o Nome do Estabelecimento\n";
                }
                if (form.txtInscEstadual.value === "") {
                    mensagem = mensagem + "Informe a Inscrição Estadual do Estabelecimento\n";
                }
                if (form.txtTelefone.value === "") {
                    mensagem = mensagem + "Informe o Telefone\n";
                }
                if (form.txtCEP.value === "") {
                    mensagem = mensagem + "Informe o CEP do Estabelecimento\n";
                }
                if (form.txtUF.value === "") {
                    mensagem = mensagem + "Informe a Unidade de Federação\n";
                }
                if (form.txtCidade.value === "") {
                    mensagem = mensagem + "Informe a Cidade do Estabelecimento\n";
                }
                if (form.txtLogradouro.value === "") {
                    mensagem = mensagem + "Informe o Logradouro do Estabelecimento\n";
                }
                if (form.txtBairro.value === "") {
                    mensagem = mensagem + "Informe o Bairro do Estabelecimento\n";
                }
                if (form.txtEdificio.value === "") {
                    mensagem = mensagem + "Informe o Número do Edifício\n";
                }
                if (!campoNumerico(form.txtIdEstabelecimento.value)) {
                    mensagem = mensagem + "Código do Estabelecimento deve ser numérico\n";
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
