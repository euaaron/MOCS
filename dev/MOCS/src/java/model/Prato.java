/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author euaar
 */
public class Prato {
    private int idPrato;
    private String nome;
    private String descricao;
    private Funcionario funcionario = null;
    private int idFuncionario;
    private Date dataCriacao;
    
    Prato(int idPrato, String nome, String descricao, Funcionario funcionario, Date dataCriacao){
        this.descricao = descricao;
        this.idFuncionario = funcionario.getIdUsuario();
        this.nome = nome;
        this.idPrato = idPrato;
        this.dataCriacao = dataCriacao;
    }

    public int getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(int idPrato) {
        this.idPrato = idPrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getFuncionario() {
        if((this.idFuncionario !=0) && (this.funcionario == null)){
        this.funcionario = Funcionario.obterFuncionario(this.idUsuario);
        }
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
