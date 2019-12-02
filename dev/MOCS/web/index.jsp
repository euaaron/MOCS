<%-- 
    Document   : index
    Created on : 25/11/2019, 15:21:24
    Author     : @euaaron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MOCS</title>
        
        <!-- Estilos, scripts e dependências de terceiros -->
        <link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css"/>
        <script src="vendor/jquery-3.3.1.slim.min.js"></script>
        <script src="vendor/popper.min.js"></script>
        <script src="vendor/bootstrap/bootstrap.min.js"></script>
        
        <!-- Estilos e scripts próprios -->
        <link rel="stylesheet" href="./css/main.css"/>
        <link rel="stylesheet" href="./css/login.css"/>
        <script src="./js/filtros.js"></script>
    </head>
    <body>
        <!-- body code goes here -->
        <div class="page-dispose full-screen">
            <div class="header total-center container-sm">
                <div>
                    <div class="display-flex total-center">
                        <h1 class="font-md-r">Bem-vindo ao <br /><span
                                class="bold black">MOCS</span></h1>
                    </div>
                    <h5 class="font-sm-r">O maior portal virtual de controle de pedidos do mundo.</h5>
                </div>
            </div>
            <div class="no-margin-left container-sm display-flex total-center">
                <div class="display-flex total-center">
                    <div class="content">
                        <div class="form-group" id="formLogin">
                            <form id="login" class="link-btn" action="inicio?acao=confirmarOperacao&operacao=logar&agente=1" name="frmLogin" method="post">
                                <label for="txtEmail">Email</label><br />
                                <input id="txtEmail" name="txtEmail" class="form-control" type="text" name="txtEmail">
                                <label for="txtSenha">Senha</label><br />
                                <input id="txtSenha" name="txtSenha" class="form-control" type="password" name="txtSenha">
                                <button id="loginUser" class=" margin-top-2 btn btn-primary btn-sm" submit>Entre</button>
                            </form>
                            <div>
                                <a id="register" class="link-btn margin-top-2" href="ManterUsuarioController?acao=prepararOperacao&operacao=Incluir"><button class="btn btn-secondary btn-light btn-sm">Registre-se</button></a>
                                <br />
                                <p id="loginGuest">Ou <a href="inicio?acao=confirmarOperacao&operacao=logar&agente=0">entre como convidado</a>.</p>
                            </div>
                            <c:if test="${erro != null}"><p>${erro}</p></c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>