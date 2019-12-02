<%-- 
    Document   : pesquisaPrato
    Created on : 02/10/2019, 13:25:31
    Author     : Débora Lessa & Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Pratos</title>

        <!-- Estilos, scripts e dependências de terceiros -->
        <link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css"/>
        <script src="vendor/jquery-3.3.1.slim.min.js"></script>
        <script src="vendor/popper.min.js"></script>
        <script src="vendor/bootstrap/bootstrap.min.js"></script>
        <!-- Estilos e scripts próprios -->
        <link rel="stylesheet" href="./css/main.css"/>
        <script src="./js/filtros.js"></script>

    </head>
    <body>
        <nav class="top-bar">
            <div class="total-center">
                <a class="navbar-brand" href="inicio">MOCS</a>
            </div>
        </nav>
        <ul class="breadcrumb">
            <li><a href="inicio">Menu</a></li>
            <li>Pesquisar</li>
        </ul>
        <h1>Pesquisar Pratos</h1>
        
        <div class="cards"><c:forEach items="${pratos}" var="prato">
            <div class="card card-style">
                <div class="card-header prato">
                    <h3 class="card-subtitle"><c:out value="${prato.nome}" /></h3>
                    <h5>Prato <c:out value="${prato.id}" />, adicionado por ${prato.funcionario.nome} em <span class="data"><c:out value="${prato.dataCriacao}"/></span></h5>
                </div>
                <div>
                    <h4 class="card-subtitle-invert">Pedidos</h4>
                    <ul class="list-group list-group-flush">
                            
                    </ul>
                </div>
                <div class="card-footer">
                    
                </div>
            </div></c:forEach>
        </div>
        
        
        <table border = 1>
            <tr>
                <th>COD</th>
                <th>FUNCIONARIO</th>
                <th>NOME</th>
                <th>DESCRIÇÃO</th>
                <th>CRIAÇÃO</th>
                <th>VALOR</th>
                <th>IMAGEM</th>
                <th>EXIBIR</th>
                <th colspan="2">OPÇÕES</th>
            </tr>
            
            <c:forEach items="${pratos}" var="prato">
                <tr>
                    <td><c:out value="${prato.id}"/></td>
                    <td><c:out value="${prato.getFuncionario().nome}"/></td>
                    <td><c:out value="${prato.nome}"/></td>
                    <td><c:out value="${prato.descricao}"/></td>
                    <td><c:out value="${prato.dataCriacao}"/></td>
                    <td>R$<c:out value="${prato.preco}"/></td>
                    <td><image src="<c:out value="${prato.imagemUrl}"/>" width="160px" heigth="90px"></td>
                    <td>
                        <c:if test="${prato.exibir == 0}">
                            <c:out value="Não"/>
                        </c:if>
                        <c:if test="${prato.exibir == 1}">
                            <c:out value="Sim"/>
                        </c:if>
                    </td>
                    <td>
                        <a href="ManterPratoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${prato.id}" />" > Editar</a>
                    </td>
                    <td>
                        <a href="ManterPratoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${prato.id}" />" > Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPratoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
