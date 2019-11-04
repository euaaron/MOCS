<%-- 
    Document   : cadastroRefeicao
    Created on : 07/09/2019, 18:45:11
    Author     : Aaron Stiebler & Débora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${operacao} Prato</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>${operacao} Prato</h1>
        <ul class="breadcrumb">
            <li><a href="index.jsp">Index Admin</a></li>
            <li><a href="PesquisarPratoController">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <form action="ManterPratoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterPrato" method="post">
            <table border="1">
                <tbody>
                    <tr>
                        <td><label>Estabelecimento:</label></td>
                        <td>
                            <select name="txtIdEstabelecimento">
                                <option value="0" <c:if test="${prato.idEstabelecimento == null}"> selected</c:if>> </option>  
                                <c:forEach items="${estabelecimentos}" var="estabelecimento">
                                    <option value="${estabelecimento.id}" <c:if test="${prato.idEstabelecimento == estabelecimento.id}"> selected</c:if>>${estabelecimento.nomeFantasia}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Funcionario:</label></td>
                        <td>
                            <select name="txtIdFuncionario">
                                <option value="0" <c:if test="${prato.idFuncionario == null}"> selected</c:if>> </option>  
                                <c:forEach items="${funcionarios}" var="funcionario">
                                    <c:if test="${prato.idEstabelecimento == estabelecimento.id}">
                                        <option value="${funcionario.id}" <c:if test="${funcionario.idEstabelecimento == estabelecimento.id}"> selected</c:if>>${funcionario.nome}</option>  
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><label for="id">Id:</label></td>
                        <td><input type="text" name="txtId" id="idPrato" value="${prato.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                    </tr>
                    <tr>
                        <td><label for="nome">Nome:</label></td>
                        <td><input type="text" name="txtNome" id="nome" value="${prato.nome}"/></td>
                    </tr>
                    <tr>
                        <td><label for="descricao">Descricao:</label></td>
                        <td><input type="text" name="txtDescricao" id="decricao" value="${prato.descricao}"/></td>
                    </tr>
                    <tr>
                        <td><label for="dataCriacao">Data da Criação:</label></td>
                        <td><input type="text" name="txtDataCriacao" id="dataCriacao" value="${prato.dataCriacao}"/></td>
                    </tr>                        
                    <tr>
                        <td>
                            <input type="submit" name="btnIncluir" value="Confirmar">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
