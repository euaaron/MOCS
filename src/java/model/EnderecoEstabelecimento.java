/**
 * Project MOCS
 *
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EnderecoEstabelecimentoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class EnderecoEstabelecimento extends Endereco {
  
  @OneToOne
  private Estabelecimento estabelecimento;

  public EnderecoEstabelecimento(Integer id, String cep, String uf,
          String cidade,
          String logradouro, String bairro, String numEdificio,
          String numComplemento) {
    super(id, cep, bairro, uf, cidade, logradouro, numEdificio, numComplemento);
  }

  // Métodos de comunicação com a camada DAO (Banco de dados)   
  public static EnderecoEstabelecimento obterEndereco(Integer idEndereco)
          throws ClassNotFoundException, SQLException {
    return EnderecoEstabelecimentoDAO.getInstancia().findById(idEndereco);
  }

  public static List<EnderecoEstabelecimento> obterEnderecos()
          throws ClassNotFoundException, SQLException {
    return EnderecoEstabelecimentoDAO.getInstancia().findAll();
  }

  public void gravar()
          throws SQLException, ClassNotFoundException {
    EnderecoEstabelecimentoDAO.getInstancia().save(this);
  }

  public void editar()
          throws SQLException, ClassNotFoundException {
    EnderecoEstabelecimentoDAO.getInstancia().save(this);
  }

  public void excluir()
          throws ClassNotFoundException, SQLException {
    EnderecoEstabelecimentoDAO.getInstancia().remove(this.getId());
  }
}
