/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.PratoDAO;
import java.sql.SQLException;

public class Prato {
    private int id;
    private String nome;
    private String descricao;
    private Funcionario funcionario = null;
    private int idFuncionario;
    private String dataCriacao;
    
    public Prato(String nome, String descricao, String dataCriacao, Funcionario funcionario){
        this.descricao = descricao;
        this.idFuncionario = funcionario.getId();
        this.nome = nome;
        this.dataCriacao = dataCriacao; // Não usar datas ou horas por enquanto! Pedido do Marco A.
    }
    
// Métodos de inserção (Modificação)
    public void setId(int idPrato) { this.id = idPrato; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }    
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }
    public void setDataCriacao(String dataCriacao) { this.dataCriacao = dataCriacao; }
    
// Métodos de Recuperação (Leitura)
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    
    public int getIdFuncionario() { return idFuncionario; }
    public String getDataCriacao() { return dataCriacao; }
    
    public Funcionario getFuncionario() throws ClassNotFoundException, SQLException {
        if((this.idFuncionario !=0) && (this.funcionario == null)){
        funcionario = Funcionario.obterFuncionario(this.idFuncionario);
        }
        return funcionario;
    }
    
// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Prato obterPrato (int idPrato) 
    throws ClassNotFoundException, SQLException  
    {
        return PratoDAO.obterPrato(idPrato);
    }
}
