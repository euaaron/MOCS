/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import java.sql.SQLException;
import java.util.List;
import dao.FuncaoDAO;

public class Funcao {
    private int id;
    private int idEstabelecimento;
    private String nome;
    private String descricao;
    private int nivelPermissao;
    
    public Funcao(int id, int idEstabelecimento, String nome, String descricao, int nivelPermissao) {
        this.id = id;
        this.idEstabelecimento = idEstabelecimento;
        this.nome = nome;
        this.descricao = descricao;
        this.nivelPermissao = nivelPermissao;
    }
    
    public void setId(int id) { this.id = id; }
    public void setIdEstabelecimento(int idEstabelecimento) { this.idEstabelecimento = idEstabelecimento; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setNivelPermissao(int nivelPermissao) { this.nivelPermissao = nivelPermissao;}
    
    public int getId() { return id; }
    public int getIdEstabelecimento() { return idEstabelecimento; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public int getNivelPermissao() { return nivelPermissao; }
    
    // Métodos de comunicação com a camada DAO (Banco de dados)
    public static Funcao obterFuncao (int id) 
    throws ClassNotFoundException, SQLException  
    {
        return FuncaoDAO.obterFuncao(id);
    }
    
    public static List<Funcao> obterFuncoes() throws ClassNotFoundException, 
    SQLException 
    {
        return FuncaoDAO.obterFuncoes();
    }
    
    public Estabelecimento obterEstabelecimento(int idEstabelecimento) throws ClassNotFoundException, 
    SQLException  
    {
        return Estabelecimento.obterEstabelecimento(idEstabelecimento);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        FuncaoDAO.gravar(this);
    }
    
    public void editar() throws SQLException, ClassNotFoundException {
        FuncaoDAO.editar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException {
        FuncaoDAO.excluir(this);
    }   
    
}
