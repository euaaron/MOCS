/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Funcionario extends Usuario {
    private Boolean statusConta;
    private Estabelecimento estabelecimento = null;
    private Funcao funcao = null;
    private int idEstabelecimento;
    private int idFuncao;
    
    public Funcionario(int idUsuario, String nome, String sobrenome, String dataNascimento,
           String email, String telefone, String senha, Estabelecimento estabelecimento, String cpf) {
        super(idUsuario, nome,sobrenome,dataNascimento,email,telefone, senha, cpf);
        this.idEstabelecimento = estabelecimento.getId();
    }    

    
    
// Métodos de inserção (Modificação)
    public void setStatusConta(Boolean statusConta) { this.statusConta = statusConta; }
    public void setFuncao(Funcao funcao){ this.funcao = funcao; }
    public void setIdEstabelecimento(int idEstabelecimento){ this.idEstabelecimento = idEstabelecimento; }
    public void setIdFuncao(int idFucao){ this.idFuncao = idFuncao; }
    
// Métodos de Recuperação (Leitura) 
    public Boolean getStatusConta() { return statusConta; }
    public Funcao getFuncao(){ return funcao; }
    public int getIdEstabelecimento(){ return idEstabelecimento; }
    public int getIdFuncao(){ return idFuncao; }
    public Estabelecimento getEstabelecimento() throws ClassNotFoundException, SQLException {
        if ((this.idEstabelecimento != 0) && (this.estabelecimento == null)) {
            this.estabelecimento = Estabelecimento.obterEstabelecimento(this.idEstabelecimento);
        }
        return this.estabelecimento;
    }
    
    public static Funcionario obterFuncionario(int idUsuario) throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionario(idUsuario);
    }
    
    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionarios();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.gravar(this);
    }
}
