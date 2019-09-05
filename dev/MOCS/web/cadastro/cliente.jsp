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
            <h1>Cadastre-se</h1>
        </div>        
        <div>
            <form action="cadastroClienteController" method="post">
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
                            <td><input type="phone" id="phone" placeholder="(xx) x xxxx-xxxx"/></td>
                        </tr>
                    </tbody>
                </table>

            </form>
        </div>
    </body>
</html>
