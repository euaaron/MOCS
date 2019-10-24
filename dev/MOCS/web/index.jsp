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
            <li>Estabelecimentos
                <ul>
                    <li><a href="PesquisarEstabelecimentoController">Pesquisar</a></li>
                    <li><a href="ManterEstabelecimentoController?acao=prepararOperacao&operacao=Incluir">Cadastrar</a></li>
                </ul>
            </li>
            <li>Usuários
                <ul>
                    <li><a href="PesquisarUsuarioController">Pesquisar</a></li>
                    <li><a href="ManterUsuarioController?acao=prepararOperacao&operacao=Incluir">Cadastrar</a></li>
                </ul>
            </li>
            <li>Funcionários
                <ul>
                    <li><a href="PesquisarFuncionarioController">Pesquisar</a></li>
                    <li><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir">Cadastrar</a></li>
                </ul>
            </li>
            <li>Proprietarios
                <ul>
                    <li><a href="PesquisarUsuarioController">Pesquisar</a></li>
                    <li><a href="ManterProprietarioController?acao=prepararOperacao&operacao=Incluir">Cadastrar</a></li>
                </ul>
            </li>
            <li>Pedidos
                <ul>
                    <li><a href="PesquisarPedidoController">Pesquisar</a></li>
                    <li><a href="ManterPedidoController?acao=prepararOperacao&operacao=Incluir">Cadastrar</a></li>
                </ul>
            </li>
            <li>Pratos
                <ul>
                    <li><a href="PesquisarPratoController">Pesquisar</a></li>
                    <li><a href="ManterPratoController?acao=prepararOperacao&operacao=Incluir">Cadastrar</a></li>
                </ul>
            </li>
        </ul>        
    </body>
</html>
