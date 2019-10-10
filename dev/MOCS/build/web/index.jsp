<%-- 
    Document   : index
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
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
        <h1>MOCS</h1>
        <ul class="breadcrumb">
            <li><a href="#">Index Admin</a></li>
        </ul>         
        <ul>
            <li><a href="PesquisaEstabelecimentoController">Estabelecimentos</a></li>
            <li><a href="PesquisaUsuarioController">Usuarios</a></li>
            <li><a href="PesquisaFuncionarioController">Funcionário</a></li>
            <li><a href="PesquisaPedidoController">Pedidos</a></li>
            <li><a href="PesquisaPratoController">Pratos</a></li>
        </ul>        
    </body>
</html>
