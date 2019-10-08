/**
 * Project MOCS
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EnderecoEstabelecimentoDAO;
import java.sql.SQLException;
import java.util.List;

public class EnderecoEstabelecimento extends Endereco{
    
    private Estabelecimento estabelecimento;
    private int idEstabelecimento;
    
    public EnderecoEstabelecimento (int id, String cep, String uf, String cidade, 
    String logradouro, String bairro, String numEdificio, String numComplemento, 
    int idEstabelecimento) 
    {
        super(id, cep, bairro, uf, cidade, logradouro, numEdificio, numComplemento);
        this.idEstabelecimento = idEstabelecimento;
    }
    
    // Métodos de inserção (Modificação)
    public void setEstabelecimento(Estabelecimento e) { this.estabelecimento = e;}
    public void setIdEstabelecimento(int idEstabelecimento) {this.idEstabelecimento = idEstabelecimento;}  
    
    // Métodos de Recuperação (Leitura)   
    public int getIdEstabelecimento() { return this.idEstabelecimento; }
    public Estabelecimento getEstabelecimento(int idEstabelecimento) 
    throws ClassNotFoundException, SQLException  
    { 
        if (estabelecimento != null) {
            return this.estabelecimento;
        }
        return Estabelecimento.obterEstabelecimento(idEstabelecimento); 
    }
    
    // Métodos de comunicação com a camada DAO (Banco de dados)   
    public static EnderecoEstabelecimento obterEndereco(int idEstabelecimento) 
    throws ClassNotFoundException, SQLException 
    {
        return EnderecoEstabelecimentoDAO.obterEndereco(idEstabelecimento);
    }
    
    public static List<EnderecoEstabelecimento> obterEnderecos() 
    throws ClassNotFoundException, SQLException 
    {
        return EnderecoEstabelecimentoDAO.obterEnderecos();
    }    
    
    public void gravar() throws SQLException, ClassNotFoundException {
        EnderecoEstabelecimentoDAO.gravar(this);
    }
}
