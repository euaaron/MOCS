<%-- 
    Document   : usuario
    Created on : 05/09/2019, 09:21:37
    Author     : Aaron Stiebler & Débora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${operacao} Usuário</title>
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
        <div>
            <h1>${operacao} Usuário</h1>
        </div>
        <ul class="breadcrumb">
            <li><a href="inicio?acao=confirmarOperacao&operacao=validar&agente=${agente}<c:if test="${idUser != null && idUser != 0}" >&idUser=${idUser}</c:if>">Index Admin</a></li>
            <li><a href="PesquisarUsuarioController&agente=${agente}<c:if test="${idUser != null && idUser != 0}" >&idUser=${idUser}</c:if>">Pesquisar</a></li>
            <li>${operacao}</li>
        </ul>
        <div>
            <form id="incluir" action="ManterUsuarioController?acao=confirmarOperacao&operacao=${operacao}&agente=${agente}<c:if test="${idUser != null && idUser != 0}" >&idUser=${idUser}</c:if>" name="frmManterUsuario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="id">Id:</label></td>
                            <td><input type="text" name="txtIdUsuario" id="id" maxlength="10" value="${usuario.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" name="txtNome" id="nome" maxlength="45" value="${usuario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td><input type="text" name="txtCpf" id="cpf" maxlength="14" placeholder="000.000.000-00" value="${usuario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="dataNascimento">Data de Nascimento:</label></td>
                            <td><input type="date" name="txtDataNascimento" id="dataNascimento" value="${usuario.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="text" id="email" maxlength="45" placeholder="exemplo@email.com" name="txtEmail" value="${usuario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="text" id="telefone" maxlength="30" placeholder="(xx) xxxx-xxxx" name="txtTelefone" value="${usuario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="password" id="senha" name="txtSenha" minlength="6" maxlength="45" value="${usuario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="confirmaSenha">Repita a senha:</label></td>
                            <td><input type="password" id="confirmaSenha" name="txtReSenha" minlength="6" maxlength="45" value="${usuario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
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
        <script>
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == - 1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            document.getElementById("incluir").addEventListener("submit", () =>
            {
                let form = document.getElementById("incluir");
                let mensagem;
                mensagem = "";
                if (form.txtIdUsuario.value === "") {
                    mensagem = mensagem + "Informe o Código do Usuário\n";
                }
                if (form.txtNome.value === "") {
                    mensagem = mensagem + "Informe o Nome do Usuário\n";
                }
                if (form.txtCpf.value === "") {
                    mensagem = mensagem + "Informe o CPF do Usuário\n";
                }
                if (form.txtEmail.value === "") {
                    mensagem = mensagem + "Digite o Email, ele será usado para login\n";
                }
                if (form.txtSenha.value == "") {
                    mensagem = mensagem + "Informe a Senha do Usuário\n";
                }
                if (form.txtReSenha.value == "") {
                    mensagem = mensagem + "Digite a Senha do Usuário novamente\n";
                }
                if (form.txtSenha.value != form.txtReSenha.value) {
                    mensagem = mensagem + "Campos de Senha diferentes\n";
                }
                if (!campoNumerico(form.txtIdUsuario.value)) {
                    mensagem = mensagem + "Código do Usuario deve ser numérico\n";
                }
                if (mensagem === "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            });
        </script>
    </body>
</html>
