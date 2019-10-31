/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.PratoDAO;
import java.sql.SQLException;
import java.util.List;

public class Prato {
    private int id;
    private String nome;
    private String descricao;
    private int idFuncionario;
    private String dataCriacao;
    private int idEstabelecimento;
    
    public Prato(int id, String nome, String descricao, String dataCriacao, int idFuncionario, int idEstabelecimento){
        this.id = id;
        this.descricao = descricao;
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.dataCriacao = dataCriacao; // Não usar datas ou horas por enquanto! Pedido do Marco A.
        this.idEstabelecimento = idEstabelecimento;
    }
    
// Métodos de inserção (Modificação)
    public void setId(int idPrato) { this.id = idPrato; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }
    public void setIdEstabelecimento(int idEstabelecimento) { this.idEstabelecimento = idEstabelecimento; }
    public void setDataCriacao(String dataCriacao) { this.dataCriacao = dataCriacao; }
    
// Métodos de Recuperação (Leitura)
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public int getIdEstabelecimento() { return idEstabelecimento; }
    public int getIdFuncionario() { return idFuncionario; }
    public String getDataCriacao() { return dataCriacao; }
        
// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Prato obterPrato (int idPrato) 
    throws ClassNotFoundException, SQLException  
    {
        return PratoDAO.obterPrato(idPrato);
    }
    
    public static List<Prato> obterPratos() throws ClassNotFoundException, SQLException {
        return PratoDAO.obterPratos();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        PratoDAO.gravar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException {
        PratoDAO.excluir(this);
    }
    
    public void editar() throws ClassNotFoundException, SQLException {
        PratoDAO.editar(this);
    }
}
