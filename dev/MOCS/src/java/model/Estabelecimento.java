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
    private ArrayList<Prato> cardapio = new ArrayList<>();
    private String cnpj;
    private String telefone;
    private String nomeFantasia;
    private String inscEstadual;

    public Estabelecimento (int id, String cnpj, String nomeFantasia,
        String inscEstadual, String telefone, int idProprietario)
    throws ClassNotFoundException, SQLException
    {
        this.id = id;
        this.idProprietario = idProprietario;        
        this.proprietario = getProprietario();
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.inscEstadual = inscEstadual;
    }

// Métodos de inserção (Modificação)
    public void setId(int id) { this.id = id; }
    public void setProprietario(Usuario proprietario) { this.proprietario = proprietario; }
    public void setIdProprietario(int idProprietario) { this.idProprietario = idProprietario; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }
    public void setInscEstadual(String inscEstadual) { this.inscEstadual = inscEstadual; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setCardapio(ArrayList<Prato> cardapio) { this.cardapio = cardapio;}    

// Métodos de Recuperação (Leitura)    
    public int getId() { return id; }
    public ArrayList<Prato> getCardapio() { return cardapio;}
    public String getCnpj() { return cnpj; }
    public String getNomeFantasia() { return nomeFantasia; }
    public String getInscEstadual() { return inscEstadual; }
    public String getTelefone() { return telefone; }
    public Usuario getProprietario() throws ClassNotFoundException, SQLException {
        if ((this.idProprietario != 0) && (this.proprietario == null)) {
            this.proprietario = Usuario.obterUsuario(this.idProprietario);
        }
        return this.proprietario;
    }
    public int getIdProprietario() { return idProprietario; }
    
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
