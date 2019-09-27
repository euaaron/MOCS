/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EnderecoDAO;
import dao.EstabelecimentoDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Endereco {
    private int id;
    private String cep;
    private String uf;
    private String cidade;
    private String logradouro;
    private String numResidencia;
    private String numComplemento;
    private Usuario usuario;
    private int idUsuario; // Usuario responsável por este endereço
    private Estabelecimento estabelecimento;
    private int idEstabelecimento;
    private boolean tipo; // true = endereco de usuario; false = endereco de estabelecimento;
    
    public Endereco (int id, String cep, String uf, String cidade, String logradouro, String numResidencia, String numComplemento, int idResidencia, boolean tipo) {
        setId(id);
        setCep(cep);
        setUf(uf);
        setCidade(cidade);
        setLogradouro(logradouro);
        setNumResidencia(numResidencia);
        setNumComplemento(numComplemento);
        setTipo(tipo);
        if (tipo==true) {
            this.idUsuario = idResidencia;
        } else {
            this.idEstabelecimento = idResidencia;
        }
    }
        
// Métodos de inserção (Modificação)
    public void setId(int id) { this.id = id; }
    public void setCep(String cep) {this.cep = cep;}
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
    public void setUsuario(Usuario usuario){ this.usuario = usuario; }
    public void setIdUsuario(int idUsuario){ this.id = idUsuario; }
    public void setEstabelecimento(Estabelecimento e){ this.estabelecimento = e;}
    public void setTipo(boolean tipo){ this.tipo = tipo; }////
    
// Métodos de Recuperação (Leitura)    
    public int getId() { return id; }
    public String getCep() { return cep; }
    public String getUf() { return uf; }
    public String getCidade() { return cidade; }
    public String getLogradouro() { return logradouro; }
    public String getNumResidencia() { return numResidencia; }
    public String getNumComplemento() { return numComplemento; }
    
// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Endereco obterEndereco(int idEndereco, boolean tipo) 
    throws ClassNotFoundException, SQLException  
    {
        return EnderecoDAO.obterEndereco(idEndereco);
    }
    
    public static List<Endereco> obterEnderecos() throws ClassNotFoundException, SQLException {
        return EnderecoDAO.obterEnderecos();
    }
    
    public static Estabelecimento getEstabelecimento(int idEstabelecimento) 
    throws ClassNotFoundException, SQLException  
    {
        return EstabelecimentoDAO.obterEstabelecimento(idEstabelecimento);        
    }
    
    public static Usuario getUsuario(int idUsuario) 
    throws ClassNotFoundException, SQLException  
    {
        return UsuarioDAO.obterUsuario(idUsuario);
    }
    
}
