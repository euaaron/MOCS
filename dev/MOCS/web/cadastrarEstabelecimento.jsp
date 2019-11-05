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
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>${operacao} Estabelecimento</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li><a href="PesquisarEstabelecimentoController">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <form action="ManterEstabelecimentoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterEstabelecimento" method="post">
            <table>
                <tr>
                    <td><label for="id">Id:</label></td>
                    <td><input type="text" name="txtIdEstabelecimento" id="idEstabelecimento" value="${estabelecimento.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for="idProprietario">Proprietario:</label></td>
                    <td>
                        <select name="txtIdProprietario" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${estabelecimento.proprietario.id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${proprietarios}" var="proprietario">
                                <option value="${proprietario.id}" <c:if test="${proprietario.id == estabelecimento.proprietario.id}"> selected</c:if>>${proprietario.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="cnpj">CNPJ:</label></td> <!-- Número do CNPJ -->
                    <td><input type="text" name="txtCnpj" id="cnpj" value="${estabelecimento.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="telefone">Telefone:</label></td> <!-- Número de telefone. -->
                    <td><input type="text" name="txtTelefone" id="telefone" value="${estabelecimento.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="nomeFantasia">Nome Fantasia:</label></td> <!-- Nome Fantasia Completo da Empresa -->
                    <td><input type="text" name="txtNomeFantasia" id="nomeFantasia" value="${estabelecimento.nomeFantasia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="inscEstadual">Inscrição Estadual:</label></td> <!-- Número da inscrição estadual da empresa -->
                    <td><input type="text" name="txtInscEstadual" id="inscEstadual" value="${estabelecimento.inscEstadual}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="idEndereco">Id do Endereco</label></td>
                    <td><input type="text" name="txtIdEndereco" id="idEndereco" value="${endestabelecimento.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="cep">CEP:</label></td>
                    <td><input type="text" id="cep" name="txtCEP" value="${endestabelecimento.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="uf">UF:</label></td>
                    <td><input type="text" id="uf" name="txtUF" value="${endestabelecimento.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="cidade">Cidade:</label></td>
                    <td><input type="text" id="cidade" name="txtCidade" value="${endestabelecimento.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="bairro">Bairro:</label></td>
                    <td><input type="text" id="bairro" name="txtBairro" value="${endestabelecimento.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="logradouro">Logradouro:</label></td>
                    <td><input type="text" id="logradouro" name="txtLogradouro" value="${endestabelecimento.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="edificio">Numero do Edificio:</label></td>
                    <td><input type="text" id="edificio" name="txtEdificio" value="${endestabelecimento.numEdificio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><label for="complemento">Complemento:</label></td>
                    <td><input type="text" id="complemento" name="txtComplemento" value="${endestabelecimento.numComplemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnIncluir" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
