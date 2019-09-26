<%-- 
    Document   : cliente
    Created on : 05/09/2019, 09:21:37
    Author     : Aaron Stiebler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastre-se</title>
    </head>
    <body>
        <div>
            <h1>Usuário</h1>
        </div>        
        <div>
            <form action="ManterUsuarioController" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" id="nome"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Email:</label></td>
                            <td><input type="email" id="email" placeholder="exemplo@email.com"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Celular:</label></td>
                            <td><input type="phone" id="tel" placeholder="(xx) x xxxx-xxxx"/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Senha:</label></td>
                            <td><input type="password" id="senha" placeholder="Ex3mpl@"></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Repita a senha:</label></td>
                            <td><input type="password" id="confirmaSenha" placeholder="Ex3mpl@"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" id="cadastrar" placeholder="Cadastrar"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <form action="ManterUsuarioController?acao=prepararOperacao&operacao=Incluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>
