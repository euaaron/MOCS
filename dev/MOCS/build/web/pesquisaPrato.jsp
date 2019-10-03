<%-- 
    Document   : pesquisaPrato
    Created on : 02/10/2019, 13:25:31
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Pratos</title>
    </head>
    <body>
        <h1>Pesquisa Pratos</h1>
        <table border = 1>
            <tr>
                <th>Código do Prato</th>
                <th>Nome do Prato</th>
                <th>Codigo do Funcionario</th>
                <th>Codigo do Estabelecimento</th>
                <th>Data da criação</th>
            </tr>
            
            <c:forEach items="${pratos}" var="prato">
                <tr>
                    <td><c:out value="${prato.id}"/></td>
                    <td><c:out value="${prato.nome}"/></td>
                    <td><c:out value="${prato.idFuncionario}"/></td>
                    <td><c:out value="${prato.idEstabelecimento}"/></td>
                    <td><c:out value="${prato.dataCriacao}"/></td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
