/**
 * Project MOCS
 *
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EnderecoUsuarioDAO;
import dao.EstabelecimentoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String cep;
  private String bairro;
  private String uf;
  private String cidade;
  private String logradouro;
  private String numEdificio;
  private String numComplemento;

  public Endereco(Integer id, String cep, String bairro, String uf, String cidade,
          String logradouro, String numEdificio, String numComplemento) {
    setBairro(bairro);
    setId(id);
    setCep(cep);
    setUf(uf);
    setCidade(cidade);
    setLogradouro(logradouro);
    setNumEdificio(numEdificio);
    setNumComplemento(numComplemento);
  }

// Métodos de inserção (Modificação)
  public void setId(int id) {
    this.id = id;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public void setNumEdificio(String numEdificio) {
    this.numEdificio = numEdificio;
  }

  public void setNumComplemento(String numComplemento) {
    this.numComplemento = numComplemento;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

// Métodos de Recuperação (Leitura)    
  public Integer getId() {
    return id;
  }

  public String getCep() {
    return cep;
  }

  public String getUf() {
    return uf;
  }

  public String getCidade() {
    return cidade;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public String getNumEdificio() {
    return numEdificio;
  }

  public String getNumComplemento() {
    return numComplemento;
  }

  public String getBairro() {
    return bairro;
  }

}
