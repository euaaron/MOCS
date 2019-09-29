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
    private ArrayList<Prato> cardapio = new ArrayList<>();
    private String cnpj;
    private String telefone;
    private String nomeFantasia;
    private String inscEstadual;
    private Endereco endereco = null;
    private int idEndereco;

    public Estabelecimento (Usuario proprietario, String cnpj, String nomeFantasia, String inscEstadual, String logradouro, String numEdificio, String bairro, String uf, String cidade, String cep, String telefone, String numComplemento){
        this.idProprietario = proprietario.getId();
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.inscEstadual = inscEstadual;
        this.endereco.setLogradouro(logradouro);
        this.endereco.setUf(uf);
        this.endereco.setNumEdificio(numEdificio);
        this.endereco.setNumComplemento(numComplemento);
        this.endereco.setBairro(bairro);
        this.endereco.setCep(cep);
        this.endereco.setCidade(cidade);
        
    }

// Métodos de inserção (Modificação)

    public void setId(int id) { this.id = id; }
    public void setProprietario(Usuario proprietario) { this.proprietario = proprietario; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }
    public void setInscEstadual(String inscEstadual) { this.inscEstadual = inscEstadual; }
    
    public void setCardapio(ArrayList<Prato> cardapio) { this.cardapio = cardapio;}
    
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setCep(String cep) { endereco.setCep(cep); }
    public void setUf(String uf) { endereco.setUf(uf); }
    public void setCidade(String cidade) { endereco.setCidade(cidade); }
    public void setBairro(String bairro) { endereco.setBairro(bairro); }
    public void setLogradouro(String logradouro) { endereco.setLogradouro(logradouro); }
    public void setNumEdificio(String numEdificio) { endereco.setNumEdificio(numEdificio); }
    public void setNumComplemento(String numComplemento) { endereco.setNumComplemento(numComplemento); }
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
    public String getNomeFantasia() { return nomeFantasia; }
    public String getInscEstadual() { return inscEstadual; }
    public String getTelefone() { return telefone; }
    public Endereco getEndereco(){ return endereco; }
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
