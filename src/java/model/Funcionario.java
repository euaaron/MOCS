/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Funcionario extends Usuario {

    private int statusConta;
    @ManyToMany
    private Estabelecimento estabelecimento;
    private Integer idEstabelecimento;
    @ManyToMany
    private Funcao funcao;
    private Integer idFuncao;

    public Funcionario(Integer idUsuario, String nome, String dataNascimento,
            String email, String telefone, String senha, String cpf,
            int statusConta,
            Integer idEstabelecimento, Integer idFuncao)
            throws ClassNotFoundException, SQLException {
        super(idUsuario, nome, dataNascimento, email, telefone, senha, cpf);
        this.idEstabelecimento = idEstabelecimento;
        this.statusConta = statusConta;
        this.idFuncao = idFuncao;
        this.estabelecimento = getEstabelecimento();
        this.funcao = getFuncao();
    }

// Métodos de inserção (Modificação)
    public void setStatusConta(int statusConta) {
        this.statusConta = statusConta;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

// Métodos de Recuperação (Leitura) 
    public int getStatusConta() {
        return statusConta;
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public Estabelecimento getEstabelecimento()
            throws ClassNotFoundException, SQLException {
        if ((this.idEstabelecimento != 0) && (this.estabelecimento == null)) {
            this.estabelecimento = Estabelecimento.obterEstabelecimento(
                    this.idEstabelecimento);
        }
        return this.estabelecimento;
    }

    public Funcao getFuncao()
            throws ClassNotFoundException, SQLException {
        if ((this.idFuncao != 0) && (this.funcao == null)) {
            this.funcao = Funcao.obterFuncao(this.idFuncao);
        }
        return this.funcao;
    }

    public static Funcionario obterFuncionario(Integer idUsuario)
            throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionario(idUsuario);
    }

    public static List<Funcionario> obterFuncionarios()
            throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionarios();
    }

    public void gravar()
            throws SQLException, ClassNotFoundException {
        FuncionarioDAO.gravar(this);
    }

    public void editar()
            throws SQLException, ClassNotFoundException {
        FuncionarioDAO.editar(this);
    }

    public void excluir()
            throws ClassNotFoundException, SQLException {
        FuncionarioDAO.excluir(this);
    }
}
