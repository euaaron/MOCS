/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author euaar
 */
public class Funcionario extends Usuario {
    private Date dataAdmissao;
    private Boolean statusConta;
    private ArrayList<Permissao> Permissoes;

    /**
     * @return the dataAdmissao
     */
    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    /**
     * @param dataAdmissao the dataAdmissao to set
     */
    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    /**
     * @return the statusConta
     */
    public Boolean getStatusConta() {
        return statusConta;
    }

    /**
     * @param statusConta the statusConta to set
     */
    public void setStatusConta(Boolean statusConta) {
        this.statusConta = statusConta;
    }

    /**
     * @return the Permissoes
     */
    public ArrayList<Permissao> getPermissoes() {
        return Permissoes;
    }

    /**
     * @param Permissoes the Permissoes to set
     */
    public void setPermissoes(ArrayList<Permissao> Permissoes) {
        this.Permissoes = Permissoes;
    }
    
}
