/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author euaar
 */
public class Estabelecimento {
    private int idEstabelecimento;
    private int idProprietario;
    private Usuario usuario = null;
    private ArrayList<Prato> cardapio = new ArrayList<Prato>();
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscEstadual;
    private String contato;
    private String logradouro;
    private String numeroEd;
    private String bairro;
    private String estado;
    private String cidade;
    private String cep;
    private String fone;
    private String fax;
    private String email;

    Estabelecimento (Usuario proprietario, String cnpj, String razaoSocial, String nomeFantasia, String inscEstadual, String contato, String logradouro, String numeroEd, String bairro, String estado, String cidade, String cep, String fone, String fax, String email){
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.cnpj = cnpj;
        this.contato = contato;
        this.email = email;
        this.estado = estado;
        this.fax = fax;
        this.fone = fone;
        this.inscEstadual = inscEstadual;
        this.logradouro = logradouro;
        this.nomeFantasia = nomeFantasia;
        this.numeroEd = numeroEd;
        this.proprietario = proprietario.getId();
        this.razaoSocial = razaoSocial;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the proprietario
     */
    public Usuario getProprietario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * @return the cardapio
     */
    public ArrayList<Prato> getCardapio() {
        return cardapio;
    }

    /**
     * @param cardapio the cardapio to set
     */
    public void setCardapio(ArrayList<Prato> cardapio) {
        this.cardapio = cardapio;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return the inscEstadual
     */
    public String getInscEstadual() {
        return inscEstadual;
    }

    /**
     * @param inscEstadual the inscEstadual to set
     */
    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numeroEd
     */
    public String getNumeroEd() {
        return numeroEd;
    }

    /**
     * @param numeroEd the numeroEd to set
     */
    public void setNumeroEd(String numeroEd) {
        this.numeroEd = numeroEd;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Usuario getProprietario() throws ClassNotFoundException, SQLException {
        if ((this.idProprietario != 0) && (this.proprietario == null)) {
            this.proprietario = Usuario.obterUsuario(this.idProprietario)
        }
        return this.proprietario;
    }
    
    public static Estabelecimento obterEstabelecimento(int idEstabelecimento) throws ClassNotFoundException, SQLException {
        return EstabelecimentoDAO.obterEstabelecimento(idEstabelecimento);
    }
    
    public static List<Estabelecimento> obterEstabelecimentos() throws ClassNotFoundException, SQLException {
        return EstabelecimentoDAO.obterEstabelecimentos();
    }
                    
}
