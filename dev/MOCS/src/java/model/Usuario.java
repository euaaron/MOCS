/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author Aaron
 */
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
    
    public Usuario(int id, String nome, String sobrenome, String dataNascimento, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }
    
    public void setEndereco(String cep, String uf, String logradouro, String numResidencia, String numComplemento) {
        setCep(cep);
        setUf(uf);
        setLogradouro(logradouro);
        setNumResidencia(numResidencia);
        setNumComplemento(numComplemento);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumResidencia() {
        return numResidencia;
    }

    public void setNumResidencia(String numResidencia) {
        this.numResidencia = numResidencia;
    }

    public String getNumComplemento() {
        return numComplemento;
    }

    public void setNumComplemento(String numComplemento) {
        this.numComplemento = numComplemento;
    }
    
    public static Usuario obterUsuario (int idUsuario) throws ClassNotFoundException, SQLException  {
        return UsuarioDAO.obterUsuario(idUsuario);
    }
}
