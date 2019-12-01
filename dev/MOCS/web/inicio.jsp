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
    <link rel="stylesheet" href="./vendor/bootstrap/bootstrap.min.css" />
    <script src="./vendor/jquery-3.3.1.slim.min.js"></script>
    <script src="./vendor/popper.min.js"></script>
    <script src="./vendor/bootstrap/bootstrap.min.js"></script>
    <script src="./vendor/fontawesome/js/all.min.js"></script>

    <!-- Estilos e scripts próprios -->
    <link rel="stylesheet" href="./css/main.css" />
    <script src="./js/filtros.js"></script>

</head>

<body>

    <nav class="top-bar">
        <div class="total-center">
            <a class="navbar-brand" href="#">MOCS</a>
        </div>
    </nav>
    <div class="menu display-flex">
        <ul >
            <li class="nav-item active">
                <a class="nav-link" href="#">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarUsuarioController">Pesquisar Usuários</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarEstabelecimentoController">Pesquisar Estabelecimentos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarFuncaoController">Pesquisar Funcões</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarFuncionarioController">Pesquisar Funcionários</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarPratoController">Pesquisar Pratos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarComandaController">Pesquisar Comandas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PesquisarPedidoController">Pesquisar Pedidos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/MOCS/">Login/Logout</a>
            </li>
        </ul>
    </div>
            
</body>

</html>