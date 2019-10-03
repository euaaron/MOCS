<%-- 
    Document   : Estabelecimento
    Created on : 05/09/2019, 09:22:06
    Author     : Débora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Estabelecimento</title>
    </head>
    <body>
        <h1>Cadastro de Estabelecimento</h1>
        <form action="cadastroEstabelecimentoController" method="post">
        <table border="1">
                <tr>
                    <td><label for="cnpj">CNPJ</label></td> <!-- Número do CNPJ -->
                    <td><input type="text" id="cnpj"></td>
                </tr>
                <tr>
                    <td><label for="razaoSocial">RazaoSocial</label></td> <!-- Nome Completo da Empresa -->
                    <td><input type="text" id="razaoSocial"></td>
                </tr>
                <tr>
                    <td><label for="nomeFantasia">Nome Fantasia</label></td> <!-- Nome Fantasia Completo da Empresa -->
                    <td><input type="text" id="nomeFantasia"></td>
                </tr>
                <tr>
                    <td><label for="inscEstadual">Inscrição Estadual</label></td> <!-- Número da inscrição estadual da empresa -->
                    <td><input type="text" id="inscEstadual"></td>
                </tr>
                <tr>
                    <td><label for="contato">Contato</label></td> <!-- Nome de uma pessoa da empresa para contato -->
                    <td><input type="text" id="contato"></td>
                </tr>
                <tr>
                    <td><label for="logradouro">Logradouro</label></td> <!-- Nome da rua, avenida etc. -->
                    <td><input type="text" id="logradouro"></td>
                </tr>
                <tr>
                    <td><label for="numero">Número</label></td> <!-- Número da edificação -->
                    <td><input type="text" id="numero"></td>
                </tr>
                <tr>
                    <td><label for="bairro">Bairro</label></td> <!-- Bairro correspondente. -->
                    <td><input type="text" id="bairro"></td>
                </tr>
                <tr>
                    <td><label for="estado">Estado</label></td> <!-- Unidade de federação correspondente. -->
                    <td><input type="text" id="estado"></td>
                </tr>
                <tr>
                    <td><label for="cidade">Cidade</label></td> <!-- Nome do município. -->
                    <td><input type="text" id="cidade"></td>
                </tr>
                <tr>
                    <td><label for="cep">CEP</label></td> <!-- Código de endereçamento postal correspondente. -->
                <a href="cadastroEstabelecimento.jsp"></a>
                    <td><input type="text" id="cep"></td>
                </tr>
                <tr>
                    <td><label for="fone">Fone</label></td> <!-- Número de telefone. -->
                    <td><input type="text" id="fone"></td>
                </tr>
                <tr>
                    <td><label for="fax">Fax</label></td> <!-- Número de fax. -->
                    <td><input type="text" id="fax"></td>
                </tr>
                <tr>
                    <td><label for="email">E-mail</label></td> <!-- Endereço eletrônico da pessoa. -->
                    <td><input type="text" id="email"></td>
                </tr>
        </table>
        </form>
    </body>
</html>
