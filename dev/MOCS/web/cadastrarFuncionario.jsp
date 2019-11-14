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
        <link rel="stylesheet" href="css/main.css"/>
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
            <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" name="frmManterFuncionario" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><label for="idEstabelecimento">Id do Estabelecimento:</label></td>
                            <td>
                                <input type="text" name="txtIdEstabelecimento" maxlength="10" id="idEstabelecimento" value="${funcionario.idEstabelecimento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="idFuncionario">Id:</label></td>
                            <td>
                                <input type="text" name="txtIdFuncionario" maxlength="10" id="idFuncionario" value="${funcionario.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="idFuncao">Função:</label></td>
                            <td>
                            <select name="txtIdFuncao" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <option value="0" <c:if test="${funcionario.idFuncao== null}"> selected</c:if>> </option>  
                                <c:forEach items="${funcoes}" var="funcao">                                    
                                <option value="${funcao.id}" <c:if test="${funcionario.idFuncao == funcao.id}"> selected</c:if>>${funcao.nome}</option>
                                </c:forEach>
                            </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="status">Status da Conta:</label></td>
                            <td>
                            <select name="txtStatusConta" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <option value="0" <c:if test="${funcionario.statusConta == 0}"> selected</c:if>/>Desativada</option>
                                <option value="1" <c:if test="${funcionario.statusConta == 1}"> selected</c:if>/>Ativada</option>  
                            </select>
                            </td>
                        </tr>                        
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td>
                                <input type="text" name="txtNome" maxlength="45" id="nome" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td>
                                <input type="text" name="txtCpf" maxlength="14" id="cpf" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="dataNasc">Data de Nascimento:</label></td>
                            <td>
                                <input type="text" name="txtDataNascimento" maxlength="10" id="dataNascimento" value="${funcionario.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="text" name="txtEmail" maxlength="45" id="email" placeholder="exemplo@email.com" value="${funcionario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="text" maxlength="30" id="telefone" placeholder="(xx) x xxxx-xxxx" name="txtTelefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="text" name="txtSenha" maxlength="45" id="senha" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Repita a senha:</label></td>
                            <td><input type="text" name="txtSenha" maxlength="45" id="confirmaSenha" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/></td>
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
    </body>
</html>
