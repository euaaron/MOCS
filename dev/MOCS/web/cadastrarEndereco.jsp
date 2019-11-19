<%-- 
    Document   : cadastroEndereco
    Created on : 26/09/2019, 09:51:38
    Author     : Aaron Stiebler e Débora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Endereco</title>

        <%-- Estilos, scripts e dependências de terceiros --%>
        <link rel="stylesheet" href="./css/bootstrap.min.css"/>
        <script src="./js/jquery-3.3.1.slim.min.js"></script>
        <%-- Estilos e scripts próprios --%>
        <link rel="stylesheet" href="./css/main.css"/>
        <script src="./js/filtros.js"></script>
        <script src="./js/popper.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
    </head>
    <body>
        <div>
            <h1>Endereco - ${operacao}</h1>
        </div>        
        <div>
            <form action="ManterEnderecoController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterEndereco" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" id="idEndereco" name="txtId" value="${endereco.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="cep">CEP:</label></td>
                            <td><input type="text" id="cep" name="txtCEP" value="${endereco.cep}"/></td>
                        </tr>
                        <tr>
                            <td><label for="uf">UF:</label></td>
                            <td><input type="text" id="uf" name="txtUF" value="${endereco.UF}"/></td>
                        </tr>
                        <tr>
                            <td><label for="cidade">Cidade:</label></td>
                            <td><input type="text" id="cidade" name="txtCidade" value="${endereco.cidade}"/></td>
                        </tr>
                        <tr>
                            <td><label for="bairro">Bairro:</label></td>
                            <td><input type="text" id="bairro" name="txtBairro" value="${usuario.bairro}"></td>
                        </tr>
                        <tr>
                            <td><label for="logradouro">Logradouro:</label></td>
                            <td><input type="text" id="logradouro" name="txtLogradouro" value="${usuario.logradouro}"></td>
                        </tr>
                        <tr>
                            <td><label for="complemento">Complemento:</label></td>
                            <td><input type="text" id="complemento" name="txtComplemento:" value="${usuario.complemento}"></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" name="btnIncluir" value="Confirmar">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
