<%-- 
    Document   : pesquisaFuncionario
    Created on : 02/10/2019, 13:35:24
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Funcionarios</title>
    </head>
    <body>
        <h1>Pesquisa de Funcionarios</h1>
        <table border = 1>
            <tr>
                <th>Código do Funcionario</th>
                <th>Nome do Funcionario</th>
                <th>CPF do Funcionario</th>
                <th>Status da Conta do Funcionario</th>
            </tr>
            
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td><c:out value="${funcionario.id}"/></td>
                    <td><c:out value="${funcionario.nome}"/></td>
                    <td><c:out value="${funcionario.cpf}"/></td>
                    <td><c:out value="${funcionario.statusConta}"/></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
