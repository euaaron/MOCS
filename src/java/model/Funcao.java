/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import java.sql.SQLException;
import java.util.List;
import dao.FuncaoDAO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer idEstabelecimento;
  private String nome;
  private String descricao;
  private int nivelPermissao;

  public Funcao(Integer id, Integer idEstabelecimento, String nome, String descricao,
          int nivelPermissao) {
    this.id = id;
    this.idEstabelecimento = idEstabelecimento;
    this.nome = nome;
    this.descricao = descricao;
    this.nivelPermissao = nivelPermissao;
  }
// Métodos de inserção de valores nas variáveis   

  public void setId(Integer id) {
    this.id = id;
  }

  public void setIdEstabelecimento(Integer idEstabelecimento) {
    this.idEstabelecimento = idEstabelecimento;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setNivelPermissao(int nivelPermissao) {
    this.nivelPermissao = nivelPermissao;
  }

// Métodos de leitura das variáveis
  public Integer getId() {
    return id;
  }

  public Integer getIdEstabelecimento() {
    return idEstabelecimento;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public int getNivelPermissao() {
    return nivelPermissao;
  }

// Métodos de comunicação com a camada DAO (Banco de dados)
  public static Funcao obterFuncao(Integer id)
          throws ClassNotFoundException, SQLException {
    return FuncaoDAO.obterFuncao(id);
  }

  public static List<Funcao> obterFuncoes()
          throws ClassNotFoundException, SQLException {
    return FuncaoDAO.obterFuncoes();
  }

  public Estabelecimento obterEstabelecimento(Integer idEstabelecimento)
          throws ClassNotFoundException, SQLException {
    return Estabelecimento.obterEstabelecimento(idEstabelecimento);
  }

  public void gravar()
          throws SQLException, ClassNotFoundException {
    FuncaoDAO.gravar(this);
  }

  public void editar()
          throws SQLException, ClassNotFoundException {
    FuncaoDAO.editar(this);
  }

  public void excluir()
          throws ClassNotFoundException, SQLException {
    FuncaoDAO.excluir(this);
  }
}
