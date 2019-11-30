<%-- 
    Document   : menu
    Created on : 03/09/2019, 09:18:20
    Author     : Aaron Stiebler e Debora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>

<html lang="pt">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MOCS - Admin</title>

    <!-- Estilos, scripts e dependências de terceiros -->
    <link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css" />
    <script src="vendor/jquery-3.3.1.slim.min.js"></script>
    <script src="vendor/popper.min.js"></script>
    <script src="vendor/bootstrap/bootstrap.min.js"></script>
    <script src="vendor/fontawesome/js/all.min.js"></script>

    <!-- Estilos e scripts próprios -->
    <link rel="stylesheet" href="./css/main.css" />
    <script src="./js/filtros.js"></script>

</head>

<body>

    <nav class="top-bar">
        <div class="total-center">
            <a class="navbar-brand" href="inicio?acao=confirmarOperacao&operacao=validar&agente=${agente}<c:if test="${idUser != null && idUser != 0}" >&idUser=${idUser}</c:if>">MOCS</a>
        </div>
    </nav>
    <div class="menu display-flex">
        <ul >
            <li class="nav-item active">
                <a class="nav-link" href="inicio?acao=confirmarOperacao&operacao=validar&agente=${agente}<c:if test="${idUser != null && idUser != 0}" >&idUser=${idUser}</c:if>">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarUsuarioController?agente=${agente}<c:if test="${idUser != null || idUser != 0}">&idUser=${idUser}</c:if>">Pesquisar Usuários</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarEstabelecimentoController?agente=${agente}<c:if test="${idUser != null || idUser != 0}">&idUser=${idUser}</c:if>">Pesquisar Estabelecimentos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarFuncaoController?agente=${agente}<c:if test="${idUser != null || idUser != 0}">&idUser=${idUser}</c:if>">Pesquisar Funcões</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarFuncionarioController?agente=${agente}<c:if test="${idUser != null || idUser != 0}">&idUser=${idUser}</c:if>">Pesquisar Funcionários</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarPratoController?agente=${agente}<c:if test="${idUser != null || idUser != 0}">&idUser=${idUser}</c:if>">Pesquisar Pratos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarComandaController?agente=${agente}<c:if test="${idUser != null || idUser != 0}">&idUser=${idUser}</c:if>">Pesquisar Comandas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarPedidoController?agente=${agente}<c:if test="${idUser != null || idUser != 0}">&idUser=${idUser}</c:if>">Pesquisar Pedidos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="inicio">Login/Logout</a>
            </li>
        </ul>
    </div>
            
</body>

</html>