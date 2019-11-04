 <%-- 
    Document   : pesquisaEstabelecimento
    Created on : 19/09/2019, 09:13:42
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Estabelecimentos</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>Pesquisar Estabelecimentos</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li>Pesquisar</li>
        </ul>
        <table border="1">
            <tr>
                <th>Cod.</th>
                <th>Nome</th>
                <th>Proprietario</th>
                <th>Cod. Endedereço</th>
                <th>UF</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>Logradouro</th>
                <th>Edifício</th>
                <th>Complemento</th>
                <th colspan="2">Opções</th>
            </tr>
            <c:forEach items="${estabelecimentos}" var="estabelecimento">
            <tr>
                <td><c:out value="${estabelecimento.id}"/></td>
                <td><c:out value="${estabelecimento.nomeFantasia}"/></td>
                <td><c:out value="${estabelecimento.getProprietario().getNome()}"/></td>
                <td><c:out value="${estabelecimento.getEndereco().getId()}"/></td>
                <td><c:out value="${estabelecimento.getEndereco().getUf()}"/></td>
                <td><c:out value="${estabelecimento.getEndereco().getCidade()}"/></td>
                <td><c:out value="${estabelecimento.getEndereco().getBairro()}"/></td>
                <td><c:out value="${estabelecimento.getEndereco().getLogradouro()}"/></td>
                <td><c:out value="${estabelecimento.getEndereco().getNumEdificio()}"/></td>
                <td><c:out value="${estabelecimento.getEndereco().getNumComplemento()}"/></td>
                <td>
                    <a href="ManterEstabelecimentoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${estabelecimento.id}" />" > Editar</a>
                </td>
                <td>
                    <a href="ManterEstabelecimentoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${estabelecimento.id}" />" > Excluir</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <form action="ManterEstabelecimentoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
