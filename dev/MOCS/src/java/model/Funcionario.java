/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Usuario {
    private Date dataAdmissao;
    private Boolean statusConta;
    private ArrayList<Permissao> Permissoes;
    private Estabelecimento estabelecimento = null;
    private int idEstabelecimento;
    
    public Funcionario(String nome, String sobrenome, String dataNascimento, String email, String telefone, String senha, Estabelecimento estabelecimento) {
        super(nome,sobrenome,dataNascimento,email,telefone, senha);
        this.idEstabelecimento = estabelecimento.getId();
    }    
    
    /**
     * @return the dataAdmissao
     */
    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    /**
     * @param dataAdmissao the dataAdmissao to set
     */
    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
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

    /**
     * @return the Permissoes
     */
    public ArrayList<Permissao> getPermissoes() {
        return Permissoes;
    }

    /**
     * @param Permissoes the Permissoes to set
     */
    public void setPermissoes(ArrayList<Permissao> Permissoes) {
        this.Permissoes = Permissoes;
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
