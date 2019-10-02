<%-- 
    Document   : pesquisaFuncionario
    Created on : 02/10/2019, 13:35:24
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Funcionario</title>
    </head>
    <body>
        <h1>Pesquisa Funcionario</h1>
        <table border = 1>
            <tr>
                <th>Código do Funcionario</th>
                <th>Nome do Funcionario</th>
                <th>Sobrenome do Funcionario</th>
                <th>CPF do Funcionario</th>
                <th>Status da Conta do Funcionario</th>
            </tr>
            
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.id}"/></td>
                    <td><c:out value="${usuario.nome}"/></td>
                    <td><c:out value="${usuario.sobrenome}"/></td>
                    <td><c:out value="${funcionario.cpf}"/></td>
                    <td><c:out value="${funcionario.statusConta}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
