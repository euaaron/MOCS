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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String cep;
  private String bairro;
  private String uf;
  private String cidade;
  private String logradouro;
  private String edificio;
  private String complemento;

  public Endereco(Integer id, String cep, String bairro, String uf, String cidade,
          String logradouro, String numEdificio, String numComplemento) {
    setBairro(bairro);
    setId(id);
    setCep(cep);
    setUf(uf);
    setCidade(cidade);
    setLogradouro(logradouro);
    setEdificio(numEdificio);
    setComplemento(numComplemento);
  }

// Métodos de inserção (Modificação)
  public void setId(Integer id) {
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

  public void setEdificio(String numEdificio) {
    this.edificio = numEdificio;
  }

  public void setComplemento(String numComplemento) {
    this.complemento = numComplemento;
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

  public String getEdificio() {
    return edificio;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getBairro() {
    return bairro;
  }

}
