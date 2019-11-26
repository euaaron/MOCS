/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String senha;
    private Endereco endereco = null;
    private int idEndereco;
    
    public Usuario(int id, String nome, String dataNascimento,
    String email, String telefone, String senha, String cpf) 
    {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }
    
// Métodos de inserção (Modificação)
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf){ this.cpf = cpf; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }    
    public void setSenha(String senha) { this.senha = senha; }
    public void setEndereco()
    throws ClassNotFoundException, SQLException
    { this.endereco = obterEndereco(idEndereco); }
    
// Métodos de Recuperação (Leitura)    
    public int getId() { return id; } 
    public String getNome() { return nome; }
    public String getCpf(){ return cpf; }
    public String getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getSenha() { return senha; }
    public Endereco getEndereco() 
    throws ClassNotFoundException, SQLException 
    {
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
    { return UsuarioDAO.obterUsuario(idUsuario); }

    public static Usuario obterUsuarioCPF (String cpf)
            throws ClassNotFoundException, SQLException
    { return UsuarioDAO.obterUsuarioCPF(cpf); }

    public static Usuario obterUsuarioEmail (String email)
            throws ClassNotFoundException, SQLException
    { return UsuarioDAO.obterUsuarioEmail(email); }
    
    public static List<Usuario> obterUsuarios() 
    throws ClassNotFoundException, SQLException 
    { return UsuarioDAO.obterUsuarios(); }
    
    public Endereco obterEndereco(int idEndereco)
    throws ClassNotFoundException, SQLException  
    { return EnderecoUsuario.obterEnderecoUsuario(idEndereco); }
    
    public Endereco obterEnderecoPadrao(int idUsuario)
    throws ClassNotFoundException, SQLException  
    { return EnderecoUsuario.obterEnderecoPadrao(idUsuario); }
    
    public static List<EnderecoUsuario> obterEnderecosUsuario(int idUsuario) 
    throws ClassNotFoundException, SQLException 
    { return EnderecoUsuario.obterEnderecosUsuario(idUsuario); }

    public void gravar()
    throws SQLException, ClassNotFoundException
    { UsuarioDAO.gravar(this); }
    
    public void editar() 
    throws SQLException, ClassNotFoundException 
    { UsuarioDAO.editar(this); }
    
    public void excluir() 
    throws ClassNotFoundException, SQLException
    { UsuarioDAO.excluir(this); }
}