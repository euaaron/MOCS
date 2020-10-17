/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EstabelecimentoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Estabelecimento {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String cnpj;
  private String telefone;
  private String nomeFantasia;
  private String inscEstadual;
  private int idProprietario;
  @ManyToOne
  private Usuario proprietario;
  private int idEndereco;
  @OneToOne
  private EnderecoEstabelecimento endereco;

  public Estabelecimento(int id, String cnpj, String nomeFantasia,
          String inscEstadual,
          String telefone, Usuario proprietario,
          EnderecoEstabelecimento endereco)
          throws ClassNotFoundException, SQLException {
    this.id = id;
    this.proprietario = proprietario;
    //this.idProprietario = proprietario.getId();
    this.cnpj = cnpj;
    this.nomeFantasia = nomeFantasia;
    this.telefone = telefone;
    this.inscEstadual = inscEstadual;
    this.endereco = endereco;
    //this.idEndereco = endereco.getId();
  }

// Métodos do objeto
  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setNomeFantasia(String nomeFantasia) {
    this.nomeFantasia = nomeFantasia;
  }

  public String getNomeFantasia() {
    return nomeFantasia;
  }

  public void setInscEstadual(String inscEstadual) {
    this.inscEstadual = inscEstadual;
  }

  public String getInscEstadual() {
    return inscEstadual;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getTelefone() {
    return telefone;
  }

//Métodos do objeto Proprietário
  public void setIdProprietario(int idProprietario) {
    this.idProprietario = idProprietario;
  }

  public int getIdProprietario() {
    return idProprietario;
  }

  public void setProprietario(Usuario proprietario) {
    this.proprietario = proprietario;
  }

  public Usuario getProprietario()
          throws ClassNotFoundException, SQLException {
    if ((this.idProprietario != 0) && (this.proprietario == null)) {
      this.proprietario = Usuario.obterUsuario(this.idProprietario);
    }
    return this.proprietario;
  }

//Métodos do objeto Endereço
  public void setIdEndereco(int idEndereco) {
    this.idEndereco = idEndereco;
  }

  public int getIdEndereco() {
    return idEndereco;
  }

  public void setEndereco(EnderecoEstabelecimento endereco) {
    this.endereco = endereco;
  }

  public EnderecoEstabelecimento getEndereco()
          throws ClassNotFoundException, SQLException {
    if ((this.idEndereco != 0) && (this.endereco == null)) {
      endereco = EnderecoEstabelecimento.obterEndereco(this.idEndereco);
    }
    return endereco;
  }

// Métodos de comunicação com a camada DAO (Banco de dados)
  public static Estabelecimento obterEstabelecimento(int idEstabelecimento)
          throws ClassNotFoundException, SQLException {
    return EstabelecimentoDAO.obterEstabelecimento(idEstabelecimento);
  }

  public static List<Estabelecimento> obterEstabelecimentos()
          throws ClassNotFoundException, SQLException {
    return EstabelecimentoDAO.obterEstabelecimentos();
  }

  /*public static List<Estabelecimento> obterEstabelecimentosProprietario(int idProprietario)
   throws ClassNotFoundException, SQLException {
   return EstabelecimentoDAO.obterEstabelecimentosProprietario(idProprietario);
   }
   */
  public void gravar()
          throws SQLException, ClassNotFoundException {
    EstabelecimentoDAO.gravar(this);
  }

  public void editar()
          throws ClassNotFoundException, SQLException {
    EstabelecimentoDAO.editar(this);
  }

  public void excluir()
          throws ClassNotFoundException, SQLException {
    EstabelecimentoDAO.excluir(this);
  }
}
