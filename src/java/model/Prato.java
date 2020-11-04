/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.PratoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prato {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String descricao;
  private Integer idFuncionario;
  @ManyToOne
  private Funcionario funcionario;
  private String dataCriacao;
  @ManyToOne
  private Estabelecimento estabelecimento;
  private Integer idEstabelecimento;
  private float preco;
  private String imagemUrl;
  private int exibir;

  public Prato(int id, String nome, String descricao, float preco,
          String imagemUrl, String dataCriacao,
          int idFuncionario, int idEstabelecimento, int exibir) throws ClassNotFoundException, SQLException {
    this.id = id;
    this.descricao = descricao;
    this.idFuncionario = idFuncionario;
    this.nome = nome;
    this.dataCriacao = dataCriacao; // Não usar datas ou horas por enquanto! Pedido do Marco A.
    this.idEstabelecimento = idEstabelecimento;
    this.preco = preco;
    this.imagemUrl = imagemUrl;
    this.exibir = exibir;
  }

// Métodos de inserção (Modificação)
  public void setId(int idPrato) {
    this.id = idPrato;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setPreco(float preco) {
    this.preco = preco;
  }

  public void setImagemUrl(String imagemUrl) {
    this.imagemUrl = imagemUrl;
  }

  public void setDataCriacao(String dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public void setIdFuncionario(int idFuncionario) {
    this.idFuncionario = idFuncionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }
  
  public void setIdEstabelecimento(int idEstabelecimento) {
    this.idEstabelecimento = idEstabelecimento;
  }

  public void setEstabelecimento(Estabelecimento estabelecimento) {
    this.estabelecimento = estabelecimento;
  }
  
  public void setExibir(int exibir) {
    this.exibir = exibir;
  }

// Métodos de Recuperação (Leitura)
  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public float getPreco() {
    return preco;
  }

  public String getImagemUrl() {
    return imagemUrl;
  }

  public String getDataCriacao() {
    return dataCriacao;
  }

  public int getIdFuncionario() {
    return idFuncionario;
  }

  public int getIdEstabelecimento() {
    return idEstabelecimento;
  }

  public int getExibir() {
    return exibir;
  }

  public Estabelecimento getEstabelecimento()
          throws ClassNotFoundException, SQLException {
    if ((this.idEstabelecimento != 0) && (this.estabelecimento == null)) {
      estabelecimento = Estabelecimento.obterEstabelecimento(
              this.idEstabelecimento);
    }
    return this.estabelecimento;
  }

  public Funcionario getFuncionario()
          throws ClassNotFoundException, SQLException {
    if ((this.idFuncionario != 0) && (this.funcionario == null)) {
      funcionario = Funcionario.obterFuncionario(this.idFuncionario);
    }
    return this.funcionario;
  }

// Métodos de comunicação com a camada DAO (Banco de dados)
  public static Prato obterPrato(int idPrato)
          throws ClassNotFoundException, SQLException {
    return PratoDAO.obterPrato(idPrato);
  }

  public static List<Prato> obterPratos()
          throws ClassNotFoundException, SQLException {
    return PratoDAO.obterPratos();
  }

  public void gravar()
          throws SQLException, ClassNotFoundException {
    PratoDAO.gravar(this);
  }

  public void editar()
          throws ClassNotFoundException, SQLException {
    PratoDAO.editar(this);
  }

  public void excluir()
          throws ClassNotFoundException, SQLException {
    PratoDAO.excluir(this);
  }

}
