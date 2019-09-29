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
    private String cpf;
    private Boolean statusConta;
    private Estabelecimento estabelecimento = null;
    private Usuario usuario = null;
    private Funcao funcao = null;
    private int idEstabelecimento;
    private int idUsuario;
    private int idFuncao;
    
    public Funcionario(int idUsuario, String nome, String sobrenome, String dataNascimento, String email, String telefone, String senha, Estabelecimento estabelecimento) {
        super(idUsuario, nome,sobrenome,dataNascimento,email,telefone, senha);
        this.idEstabelecimento = estabelecimento.getId();
    }    

    /**
     * @return the statusConta
     */
    public Boolean getStatusConta() {
        return statusConta;
    }

    /**
     * @param statusConta the statusConta to set
     */
    public void setStatusConta(Boolean statusConta) {
        this.statusConta = statusConta;
    }
    
    public Estabelecimento getEstabelecimento() throws ClassNotFoundException, SQLException {
        if ((this.idEstabelecimento != 0) && (this.estabelecimento == null)) {
            this.estabelecimento = Estabelecimento.obterEstabelecimento(this.idEstabelecimento);
        }
        return this.estabelecimento;
    }
    
    public static Funcionario obterFuncionario(int idFuncionario) throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionario(idFuncionario);
    }
    
    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionarios();
    }
    
}
