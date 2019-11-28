<%-- 
    Document   : cadastroFuncionario
    Created on : 05/09/2019, 10:20:01
    Author     : Aaron Stiebler & Débora Lessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${operacao} Funcionario</title>
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
            <h1>${operacao} Funcionario</h1>
            <ul class="breadcrumb">
                <li><a href="index.jsp">Index Admin</a></li>
                <li><a href="PesquisarFuncionarioController">Pesquisar</a></li>
                <li>${operacao}</li>
            </ul>
        </div>        
        <div>
            <form id="incluir" action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterFuncionario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                        <td><label>Estabelecimento:</label></td>
                        <td>
                            <select name="txtIdEstabelecimento">
                                <option value="0" <c:if test="${funcionario.idEstabelecimento == null}"> selected</c:if>> </option>  
                                <c:forEach items="${estabelecimentos}" var="estabelecimento">
                                <option value="${estabelecimento.id}" <c:if test="${funcionario.idEstabelecimento == estabelecimento.id}"> selected</c:if>>${estabelecimento.nomeFantasia}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>    
                        <tr>
                            <td><label for="idFuncionario">Id:</label></td>
                            <td>
                                <input type="text" name="txtIdFuncionario" id="idFuncionario" maxlength="10" value="${funcionario.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="status">Status da Conta:</label></td>
                            <td>
                            <select id="status" name="txtStatusConta">
                                <option value="0">Desativada</option>
                                <option value="1">Ativada</option>  
                            </select>
                            </td>
                        </tr>                        
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td>
                                <input type="text" name="txtNome" id="nome" maxlength="45" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td>
                                <input type="text" name="txtCpf" id="cpf" maxlength="14" placeholder="000.000.000-00" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="dataNascimento">Data de Nascimento:</label></td>
                            <td>
                                <input type="date" name="txtDataNascimento" maxlength="10" id="dataNascimento" value="${funcionario.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="text" name="txtEmail" id="email" placeholder="exemplo@email.com" maxlength="45" value="${funcionario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="text" id="telefone" placeholder="(xx) xxxx-xxxx" name="txtTelefone" maxlength="30" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="idFuncao">Função:</label></td>
                            <td>
                            <select id="idFuncao" name="txtIdFuncao">
                                <option value="0" <c:if test="${funcionario.idFuncao== null}"> selected</c:if>> </option>  
                                <c:forEach items="${funcoes}" var="funcao">                                    
                                <option value="${funcao.id}" <c:if test="${funcionario.idFuncao == funcao.id}"> selected</c:if>>${funcao.nome}</option>
                                </c:forEach>
                            </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="password" name="txtSenha" id="senha" maxlength="45" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Repita a senha:</label></td>
                            <td><input type="password" name="txtReSenha" id="confirmaSenha" maxlength="45" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" name="btnIncluir" value="Confirmar"/>
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
                if (form.txtIdEstabelecimento.value === "") {
                    mensagem = mensagem + "Informe o Código do Estabelecimento\n";
                }
                if (form.txtIdFuncionario.value === "") {
                    mensagem = mensagem + "Informe o Código do Funcionário\n";
                }
                if (form.txtStatusConta.value === "") {
                    mensagem = mensagem + "Informe o Status da Conta do Funcionário\n";
                }
                if (form.txtNome.value === "") {
                    mensagem = mensagem + "Informe o Nome do Funcionário\n";
                }
                if (form.txtCpf.value === "") {
                    mensagem = mensagem + "Informe o CPF do Funcionário\n";
                }
                if (form.txtEmail.value === "") {
                    mensagem = mensagem + "Informe o Email do Funcionário\n";
                }
                if (form.txtIdFuncao.value === "") {
                    mensagem = mensagem + "Informe a Função do Funcionário\n";
                }
                if (form.txtSenha.value == "") {
                    mensagem = mensagem + "Informe a Senha do Funcionário\n";
                }
                if (form.txtReSenha.value == "") {
                    mensagem = mensagem + "Digite a Senha do Funcionário novamente\n";
                }
                if (form.txtSenha.value != form.txtReSenha.value) {
                    mensagem = mensagem + "Campos de Senha diferentes\n";
                }
                if (!campoNumerico(form.txtIdEstabelecimento.value)) {
                    mensagem = mensagem + "Código do Estabelecimento deve ser numérico\n";
                }
                if (!campoNumerico(form.txtIdFuncionario.value)) {
                    mensagem = mensagem + "Código do Funcionário deve ser numérico\n";
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
