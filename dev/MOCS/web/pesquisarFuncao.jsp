<%-- 
    Document   : pesquisarFuncao
    Created on : 24/10/2019, 10:33:46
    Author     : euaar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Funcões</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>Pesquisar Funcões</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li>Pesquisar Funcões</li>
        </ul>
        <table border = 1>
            <tr>
                <th>Código da Funcão</th>
                <th>Nome da Funcão</th>
                <th>Opções</th>
            </tr>
            
            <c:forEach items="${funcoes}" var="funcao">
                <tr>
                    <td><c:out value="${funcao.id}"/></td>
                    <td><c:out value="${funcao.nome}"/></td>
                    <td>
                        <a href="ManterFuncaoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${funcao.id}" />" > Editar</a>
                        <a href="ManterFuncaoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${funcao.id}" />" > Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFuncaoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>