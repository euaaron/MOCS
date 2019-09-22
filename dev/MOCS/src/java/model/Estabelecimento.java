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

public class Estabelecimento {
    private int id;
    private int idProprietario;
    private Usuario proprietario = null;
    private ArrayList<Prato> cardapio = new ArrayList<Prato>();
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscEstadual;
    private String contato;
    private String logradouro;
    private String numEdificio;
    private String bairro;
    private String uf;
    private String cidade;
    private String cep;
    private String telefone;
    private String fax;
    private String email;

    public Estabelecimento (Usuario proprietario, String cnpj, String razaoSocial, String nomeFantasia, String inscEstadual, String contato, String logradouro, String numEdificio, String bairro, String uf, String cidade, String cep, String fone, String fax, String email){
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.cnpj = cnpj;
        this.contato = contato;
        this.email = email;
        this.uf = uf;
        this.fax = fax;
        this.telefone = fone;
        this.inscEstadual = inscEstadual;
        this.logradouro = logradouro;
        this.nomeFantasia = nomeFantasia;
        this.numEdificio = numEdificio;
        this.idProprietario = proprietario.getId();
        this.razaoSocial = razaoSocial;
    }

// Métodos de inserção (Modificação)

    public void setId(int id) { this.id = id; }
    public void setProprietario(Usuario proprietario) { this.proprietario = proprietario; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }
    public void setInscEstadual(String inscEstadual) { this.inscEstadual = inscEstadual; }
    
    public void setCardapio(ArrayList<Prato> cardapio) { this.cardapio = cardapio;}
    
    public void setContato(String contato) { this.contato = contato; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setFax(String fax) { this.fax = fax; }
    public void setCep(String cep) { this.cep = cep; }
    public void setUf(String uf) { this.uf = uf; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public void setNumEdificio(String numEdificio) { this.numEdificio = numEdificio; }
    public void setEndereco(String cep, String uf, String cidade, String logradouro, String numEdificio) {
        setCep(cep);
        setUf(uf);
        setCidade(cidade);
        setLogradouro(logradouro);
        setNumEdificio(numEdificio);
    }

// Métodos de Recuperação (Leitura)    
    public int getId() { return id; }
    public ArrayList<Prato> getCardapio() { return cardapio;}
    public String getCnpj() { return cnpj; }
    public String getRazaoSocial() { return razaoSocial; }
    public String getNomeFantasia() { return nomeFantasia; }
    public String getInscEstadual() { return inscEstadual; }
    public String getContato() { return contato; }
    public String getTelefone() { return telefone; }

    public String getFax() {
        if (fax != null) {return fax;}
        else return "NULO";
    }
    public String getEmail() { return email; }
    public Usuario getProprietario() throws ClassNotFoundException, SQLException {
        if ((this.idProprietario != 0) && (this.proprietario == null)) {
            this.proprietario = Usuario.obterUsuario(this.idProprietario);
        }
        return this.proprietario;
    }
    
// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Estabelecimento obterEstabelecimento(int idEstabelecimento) throws ClassNotFoundException, SQLException {
        return EstabelecimentoDAO.obterEstabelecimento(idEstabelecimento);
    }
    
    public static List<Estabelecimento> obterEstabelecimentos() throws ClassNotFoundException, SQLException {
        return EstabelecimentoDAO.obterEstabelecimentos();
    }
                    
}
