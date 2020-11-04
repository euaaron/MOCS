/**
 * Project MOCS
 *
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EnderecoUsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class EnderecoUsuario extends Endereco {

  @ManyToOne
  private Usuario usuario;
  private Integer idUsuario; // Usuario responsável por este endereço
  private boolean padrao;

  public EnderecoUsuario(Integer id, String cep, String bairro, String uf,
          String cidade,
          String logradouro, String numEdificio, String numComplemento,
          Integer idUsuario, boolean padrao) {
    super(id, cep, bairro, uf, cidade, logradouro, numEdificio, numComplemento);
    this.idUsuario = idUsuario;
    this.padrao = padrao;
  }

  // Métodos de inserção (Modificação)
  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public void setPadrao(boolean padrao) {
    this.padrao = padrao;
  }

  // Métodos de Recuperação (Leitura)    
  public Integer getIdUsuario() {
    return this.idUsuario;
  }

  public boolean getPadrao() {
    return this.padrao;
  }

  public Usuario getUsuario(Integer idUsuario)
          throws ClassNotFoundException, SQLException {
    if (usuario != null) {
      return this.usuario;
    }
    return Usuario.obterUsuario(idUsuario);
  }

  // Métodos de comunicação com a camada DAO (Banco de dados)    
  public static EnderecoUsuario obterEnderecoPadrao(int idUsuario)
          throws ClassNotFoundException, SQLException {
    return EnderecoUsuarioDAO.obterEnderecoPadrao(idUsuario);
  }

  public static EnderecoUsuario obterEnderecoUsuario(int idEndereco)
          throws ClassNotFoundException, SQLException {
    return EnderecoUsuarioDAO.obterEnderecoUsuario(idEndereco);
  }

  public static List<EnderecoUsuario> obterEnderecosUsuario(int idUsuario)
          throws ClassNotFoundException, SQLException {
    return EnderecoUsuarioDAO.obterEnderecosUsuario(idUsuario);
  }

  public static List<EnderecoUsuario> obterEnderecosUsuarios()
          throws ClassNotFoundException, SQLException {
    return EnderecoUsuarioDAO.obterEnderecosUsuarios();
  }

  public void gravar()
          throws SQLException, ClassNotFoundException {
    EnderecoUsuarioDAO.gravar(this);
  }

  public void editar()
          throws SQLException, ClassNotFoundException {
    EnderecoUsuarioDAO.editar(this);
  }

  public void excluir()
          throws ClassNotFoundException, SQLException {
    EnderecoUsuarioDAO.excluir(this);
  }
}
