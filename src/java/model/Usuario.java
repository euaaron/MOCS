/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dao.UsuarioDAO;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String cpf;
  private String dataNascimento;
  private String email;
  private String telefone;
  private String senha;

  public Usuario(Integer id, String nome, String dataNascimento,
          String email, String telefone, String senha, String cpf) {
    this.id = id;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.email = email;
    this.cpf = cpf;
    this.telefone = telefone;
    this.senha = senha;
  }

// Métodos de inserção (Modificação)
  public void setId(Integer id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
  
// Métodos de Recuperação (Leitura)    
  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public String getEmail() {
    return email;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getSenha() {
    return senha;
  }
  
// Métodos de comunicação com a camada DAO (Banco de dados)
  public static Usuario obterUsuario(Integer idUsuario)
          throws ClassNotFoundException, SQLException {
    return UsuarioDAO.getInstancia().findById(idUsuario);
  }

//  public static Usuario obterUsuarioCPF(String cpf)
//          throws ClassNotFoundException, SQLException {
//    return UsuarioDAO.obterUsuarioCPF(cpf);
//  }
//
//  public static Usuario obterUsuarioEmail(String email)
//          throws ClassNotFoundException, SQLException {
//    return UsuarioDAO.obterUsuarioEmail(email);
//  }

  public static List<Usuario> obterUsuarios()
          throws ClassNotFoundException, SQLException {
    return UsuarioDAO.getInstancia().findAll();
  }
  
  public void gravar()
          throws SQLException, ClassNotFoundException {
    UsuarioDAO.getInstancia().save(this);
  }

  public void editar()
          throws SQLException, ClassNotFoundException {
    UsuarioDAO.getInstancia().save(this);
  }

  public void excluir()
          throws ClassNotFoundException, SQLException {
    UsuarioDAO.getInstancia().remove(this.id);
  }
}
