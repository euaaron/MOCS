<%-- 
    Document   : pesquisaProprietario
    Created on : 03/10/2019, 16:16:01
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Proprietario</title>
    </head>
    <body>
        <h1>Pesquisa Proprietario</h1>
        <table border = 1>
            <tr>
                <th>Código do Usuário</th>
                <th>Nome do Usuario</th>
                <th>Sobrenome do Usuario</th>
            </tr>
            
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.id}"/></td>
                    <td><c:out value="${usuario.nome}"/></td>
                    <td><c:out value="${usuario.sobrenome}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
