<%-- 
    Document   : PesquisaUsuario
    Created on : 19/09/2019, 09:12:57
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Usuarios</title>
    </head>
    <body>
        <h1>Pesquisa de Usuarios</h1>
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
