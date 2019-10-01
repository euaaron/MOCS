/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EnderecoUsuarioDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    private int id;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String senha;
    private Endereco endereco = null;
    private int idEndereco;
    
    public Usuario(int id, String nome, String sobrenome, String dataNascimento, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }
    
// Métodos de inserção (Modificação)
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }    
    public void setSenha(String senha) { this.senha = senha; }
    public void setEndereco() throws ClassNotFoundException, SQLException {
        this.endereco = obterEndereco(idEndereco);
    }
    
// Métodos de Recuperação (Leitura)    
    public int getId() { return id; } 
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public String getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getSenha() { return senha; }
    public Endereco getEndereco() throws ClassNotFoundException, SQLException {
        if(endereco == null) {
            setEndereco();
            return this.endereco;
        }
        return this.endereco;
    }
    
// Endereco
    public String getCep() { return endereco.getCep(); }
    public String getUf() { return endereco.getUf(); }
    public String getCidade() { return endereco.getCidade(); }
    public String getLogradouro() { return endereco.getLogradouro();}
    public String getNumEdificio() { return endereco.getNumEdificio(); }
    public String getNumComplemento() { return endereco.getNumComplemento(); }

// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Usuario obterUsuario (int idUsuario) 
    throws ClassNotFoundException, SQLException  
    {
        return UsuarioDAO.obterUsuario(idUsuario);
    }
    
    public static List<Usuario> obterUsuarios() throws ClassNotFoundException, 
    SQLException 
    {
        return UsuarioDAO.obterUsuarios();
    }
    
    public Endereco obterEndereco(int idEndereco) throws ClassNotFoundException, 
    SQLException  
    {
        return EnderecoUsuarioDAO.obterEnderecoUsuario(idEndereco);
    }
    
    public static List<EnderecoUsuario> obterEnderecosUsuario(int idUsuario) 
    throws ClassNotFoundException, SQLException 
    {
        return EnderecoUsuarioDAO.obterEnderecosUsuario(idUsuario);
    }

}