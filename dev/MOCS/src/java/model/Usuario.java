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
    private String sobrenome;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String cep;
    private String uf;
    private String cidade;
    private String logradouro;
    private String numResidencia;
    private String numComplemento;
    private String senha;
    
    public Usuario(String nome, String sobrenome, String dataNascimento, String email, String telefone, String senha) {
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
    public void setCep(String cep) { this.cep = cep; }
    public void setUf(String uf) { this.uf = uf; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public void setNumResidencia(String numResidencia) { this.numResidencia = numResidencia; }
    public void setNumComplemento(String numComplemento) { this.numComplemento = numComplemento; }
    public void setEndereco(String cep, String uf, String cidade, String logradouro, String numResidencia, String numComplemento) {
        setCep(cep);
        setUf(uf);
        setCidade(cidade);
        setLogradouro(logradouro);
        setNumResidencia(numResidencia);
        setNumComplemento(numComplemento);
    }
    public void setSenha(String senha) { this.senha = senha; }
    
// Métodos de Recuperação (Leitura)    
    public int getId() { return id; } 
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public String getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getCep() { return cep; }
    public String getUf() { return uf; }
    public String getCidade() { return cidade; }
    public String getLogradouro() { return logradouro; }
    public String getNumResidencia() { return numResidencia; }
    public String getNumComplemento() { return numComplemento; }
    public String getSenha() { return senha; }

// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Usuario obterUsuario (int idUsuario) 
    throws ClassNotFoundException, SQLException  
    {
        return UsuarioDAO.obterUsuario(idUsuario);
    }
    
    public static List<Usuario> obterUsuarios() throws ClassNotFoundException, SQLException {
        return UsuarioDAO.obterUsuarios();
    }
}