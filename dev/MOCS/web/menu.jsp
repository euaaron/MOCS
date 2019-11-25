<%-- 
    Document   : menu
    Created on : 03/09/2019, 09:18:20
    Author     : Aaron Stiebler e Debora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MOCS - Admin</title>

        <%-- Estilos, scripts e dependências de terceiros --%>
        <link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css"/>
        <script src="vendor/jquery-3.3.1.slim.min.js"></script>
        <script src="vendor/popper.min.js"></script>
        <script src="vendor/bootstrap/bootstrap.min.js"></script>
        
        <%-- Estilos e scripts próprios --%>
        <link rel="stylesheet" href="./css/main.css"/>
        <script src="./js/filtros.js"></script>
    </head>
    <body>
        <h1>MOCS</h1>
        <ul class="breadcrumb">
            <li>Index Admin</li>
        </ul>         
        <ul>
            <li>
                <a href="PesquisarUsuarioController">Pesquisar Usuários</a>
            </li>
            <li>
                <a href="PesquisarEstabelecimentoController">Pesquisar Estabelecimentos</a>
            </li>
            <li>
                <a href="PesquisarFuncaoController">Pesquisar Funcões</a>
            </li>
            <li>
                <a href="PesquisarFuncionarioController">Pesquisar Funcionários</a>
            </li>
            <li>
                <a href="PesquisarPratoController">Pesquisar Pratos</a>
            </li>
            <li>
                <a href="PesquisarComandaController">Pesquisar Comandas</a>
            </li>
            <li>
                <a href="PesquisarPedidoController">Pesquisar Pedidos</a>
            </li>                
        </ul>        
    </body>
</html>
