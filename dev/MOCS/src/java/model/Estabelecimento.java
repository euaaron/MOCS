/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EstabelecimentoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Estabelecimento {
    private int id;
    private int idProprietario;
    private Usuario proprietario;
    private String cnpj;
    private String telefone;
    private String nomeFantasia;
    private String inscEstadual;
    private int idEndereco;
    private EnderecoEstabelecimento endereco;

    public Estabelecimento (int id, String cnpj, String nomeFantasia, String inscEstadual,
    String telefone, int idProprietario, int idEndereco)
    throws ClassNotFoundException, SQLException
    {
        this.id = id;
        this.idProprietario = idProprietario;        
        this.proprietario = getProprietario();
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.inscEstadual = inscEstadual;
        this.idEndereco = idEndereco;
    }

// Métodos do objeto
    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
    
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getCnpj() { return cnpj; }
    
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }
    public String getNomeFantasia() { return nomeFantasia; }
    
    public void setInscEstadual(String inscEstadual) { this.inscEstadual = inscEstadual; }
    public String getInscEstadual() { return inscEstadual; }
    
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getTelefone() { return telefone; }
    
//Métodos do objeto Proprietário
    public void setIdProprietario(int idProprietario) { this.idProprietario = idProprietario; }
    public int getIdProprietario() { return idProprietario; }
    
    public void setProprietario(Usuario proprietario) { this.proprietario = proprietario; }
    public Usuario getProprietario() 
    throws ClassNotFoundException, SQLException {
        if ((this.idProprietario != 0) && (this.proprietario == null)) 
        {
            this.proprietario = Usuario.obterUsuario(this.idProprietario);
        }
        return this.proprietario;
    }
    
//Métodos do objeto Endereço
    public void setIdEndereco(int idEndereco) { this.idEndereco = idEndereco; }
    public int getIdEndereco() { return idEndereco; }
    
    public void setEndereco(EnderecoEstabelecimento endereco) { this.endereco = endereco; }
    public EnderecoEstabelecimento getEndereco()
    throws ClassNotFoundException, SQLException 
    {
        if ((this.idEndereco != 0) && (this.endereco == null)) 
        {
            endereco = EnderecoEstabelecimento.obterEnderecoEstabelecimento(idEndereco);
        }
        return this.endereco;
    }
    
// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Estabelecimento obterEstabelecimento(int idEstabelecimento) 
    throws ClassNotFoundException, SQLException 
    { return EstabelecimentoDAO.obterEstabelecimento(idEstabelecimento); }
    
    public static List<Estabelecimento> obterEstabelecimentos() 
    throws ClassNotFoundException, SQLException 
    { return EstabelecimentoDAO.obterEstabelecimentos(); }
    
    public static List<Estabelecimento> obterEstabelecimentosProprietario(int idProprietario) 
    throws ClassNotFoundException, SQLException 
    { return EstabelecimentoDAO.obterEstabelecimentosProprietario(idProprietario); }
    
    public void gravar() 
    throws SQLException, ClassNotFoundException 
    { EstabelecimentoDAO.gravar(this); }
    
    public void editar() 
    throws ClassNotFoundException, SQLException 
    { EstabelecimentoDAO.editar(this); }
    
    public void excluir() 
    throws ClassNotFoundException, SQLException 
    { EstabelecimentoDAO.excluir(this); } 
}
