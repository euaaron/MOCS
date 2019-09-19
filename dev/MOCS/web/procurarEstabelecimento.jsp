<%-- 
    Document   : procurarEstabelecimento
    Created on : 19/09/2019, 09:13:42
    Author     : euaar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estabelecimentos</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <c:forEach items="${estabelecimentos}" var="curso">
        <tr>
            <td><c:out value="${estabelecimento.id}"/></td>
            <td><c:out value="${estabelecimento.nome}"/></td>
            <td><c:out value="${estabelecimento.proprietario}"/></td>
        </tr>
        </c:forEach>      
        
    </body>
</html>
