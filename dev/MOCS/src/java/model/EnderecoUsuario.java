/**
 * Project MOCS
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EnderecoUsuarioDAO;
import java.sql.SQLException;
import java.util.List;

public class EnderecoUsuario extends Endereco {
    
    private Usuario usuario;
    private int idUsuario; // Usuario responsável por este endereço
    private boolean padrao;
    
    public EnderecoUsuario (int id, String cep, String bairro, String uf, String cidade,
    String logradouro, String numEdificio, String numComplemento, int idUsuario, boolean padrao) {
        super(id, cep, bairro, uf, cidade, logradouro, numEdificio, numComplemento);
        this.idUsuario = idUsuario;
        this.padrao = padrao;
    }
    
    // Métodos de inserção (Modificação)
    public void setIdUsuario(int idUsuario){ this.idUsuario = idUsuario; }
    public void setUsuario(Usuario usuario){ this.usuario = usuario; }
    public void setPadrao(boolean padrao) { this.padrao = padrao; }
    
    // Métodos de Recuperação (Leitura)    
    public int getIdUsuario() { return this.idUsuario; }
    public boolean getPadrao() { return this.padrao; }
    public Usuario getUsuario(int idUsuario) 
    throws ClassNotFoundException, SQLException  
    { 
        if (usuario != null) {
            return this.usuario;
        }
        return Usuario.obterUsuario(idUsuario); 
    }
    
    // Métodos de comunicação com a camada DAO (Banco de dados)    
    public static EnderecoUsuario obterEnderecoPadrao(int idUsuario) 
    throws ClassNotFoundException, SQLException  
    {
        return EnderecoUsuarioDAO.obterEnderecoPadrao(idUsuario);
    }
    
    public static EnderecoUsuario obterEnderecoUsuario(int idEndereco) 
    throws ClassNotFoundException, SQLException  
    {
        return EnderecoUsuarioDAO.obterEnderecoUsuario(idEndereco);
    }
    
    public static List<EnderecoUsuario> obterEnderecosUsuario(int idUsuario) 
    throws ClassNotFoundException, SQLException 
    {
        return EnderecoUsuarioDAO.obterEnderecosUsuario(idUsuario);
    }
    
    public static List<EnderecoUsuario> obterEnderecosUsuarios() 
    throws ClassNotFoundException, SQLException 
    {
        return EnderecoUsuarioDAO.obterEnderecosUsuarios();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        EnderecoUsuarioDAO.gravar(this);
    }
    
}
