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
        
    public EnderecoEstabelecimento (int id, String cep, String uf, String cidade, 
    String logradouro, String bairro, String numEdificio, String numComplemento) 
    {
        super(id, cep, bairro, uf, cidade, logradouro, numEdificio, numComplemento);
    }
    
    // Métodos de comunicação com a camada DAO (Banco de dados)   
    public static EnderecoEstabelecimento obterEndereco(int idEstabelecimento) 
    throws ClassNotFoundException, SQLException 
    { return EnderecoEstabelecimentoDAO.obterEndereco(idEstabelecimento); }
    
    public static List<EnderecoEstabelecimento> obterEnderecos() 
    throws ClassNotFoundException, SQLException 
    { return EnderecoEstabelecimentoDAO.obterEnderecos(); }    
    
    public void gravar() 
    throws SQLException, ClassNotFoundException 
    { EnderecoEstabelecimentoDAO.gravar(this); }
    
    public void editar()
    throws SQLException, ClassNotFoundException 
    { EnderecoEstabelecimentoDAO.editar(this); }
    
    public void excluir() 
    throws ClassNotFoundException, SQLException 
    { EnderecoEstabelecimentoDAO.excluir(this); }
}
