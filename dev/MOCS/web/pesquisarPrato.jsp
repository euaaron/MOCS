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
    <body onload="setDate()">
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
        <div class="d-flex justify-content-center margin-3">
            <form action="ManterPratoController?acao=prepararOperacao&operacao=Incluir" method="post">
                <button class="btn btn-primary btn-lg" type="submit" name="btnIncluir">Novo Prato</button>
            </form>
        </div>
        <div class="cards"><c:forEach items="${pratos}" var="prato">
            <div class="card card-style">
                <image class="card-img-top prato" src="<c:out value="${prato.imagemUrl}"/>">
                <h4 class="card-subtitle-invert">R$ ${prato.preco}</h4>
                <div class="card-header prato">
                    <h3 class="card-subtitle"><c:out value="${prato.nome}" /></h3>
                </div>
                <div class="card-body">
                    <p class="card-text">${prato.descricao}</p>
                </div>
                <div class="card-footer text-muted">
                    <div class="row">
                        <div class="col">ID</div>
                        <div class="col">
                            Add. por
                        </div>
                        <div class="col">
                            Criado em
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <b><c:out value="${prato.id}" /></b>
                        </div>
                        <div class="col">
                            <b>${prato.funcionario.nome}</b>
                        </div>
                        <div class="col">
                            <b class="data">${prato.dataCriacao}</b>
                        </div>
                    </div>
                        <div class="row">
                        <div class="col">Exibir</div>
                        <div class="col">Opções</div>
                    </div>
                        <div class="row">
                        <div class="col">
                            <b>
                                <c:if test="${prato.exibir == 0}">Não</c:if>
                                <c:if test="${prato.exibir == 1}">Sim</c:if>
                            </b>
                        </div>
                        <div class="col">
                            <a href="ManterPratoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${prato.id}" />" > <i class="fas fa-edit"></i> Editar</a>
                        </div>
                        <div class="col">
                            <a href="ManterPratoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${prato.id}" />" > <i class="fas fa-trash"></i> Excluir</a>
                        </div>
                    </div>
                </div>
            </div></c:forEach>
        </div>
        <script type="text/javascript">
        </script>
    </body>
</html>
