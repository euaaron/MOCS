/**
 * @title Projeto MOCS
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.ComandaDAO;
import dao.PedidoDAO;
import dao.PratoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer idComanda;
  private Integer idPrato;
  private int quantidade;
  @OneToOne
  private Prato prato = null;
  @ManyToOne
  private Comanda comanda = null;

  public Pedido(Integer id, Integer idPrato, int quantidade, Integer idComanda) {
    this.id = id;
    this.idPrato = idPrato;
    this.quantidade = quantidade;
    this.idComanda = idComanda;
  }

//Métodos de inserção (Modificação)
  public void setId(Integer idPedido) {
    this.id = idPedido;
  }

  public void setPrato(Prato prato) {
    this.prato = prato;
  }

  public void setComanda(Comanda comanda) {
    this.comanda = comanda;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public void setIdComanda(Integer idComanda) {
    this.idComanda = idComanda;
  }

  public void setIdPrato(Integer idPrato) {
    this.idPrato = idPrato;
  }

// Métodos de Recuperação (Leitura)
  public Integer getId() {
    return id;
  }

  public Integer getIdPrato() {
    return idPrato;
  }

  public Integer getIdComanda() {
    return idComanda;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public Comanda getComanda()
          throws ClassNotFoundException, SQLException {
    if ((idComanda != 0) && (comanda == null)) {
      comanda = Comanda.obterComanda(idComanda);
    }
    return this.comanda;
  }

  public Prato getPrato()
          throws ClassNotFoundException, SQLException {
    if ((idPrato != 0) && (prato == null)) {
      prato = Prato.obterPrato(idPrato);
    }
    return this.prato;
  }

// Métodos de comunicação com a camada DAO (Banco de dados)
  public static Pedido obterPedido(Integer id)
          throws ClassNotFoundException, SQLException {
    return PedidoDAO.getInstancia().findById(id);
  }

  public static List<Pedido> obterPedidos()
          throws ClassNotFoundException, SQLException {
    return PedidoDAO.getInstancia().findAll();
  }
  /*
  public static List<Pedido> obterPedidosComanda(Integer idComanda)
          throws ClassNotFoundException, SQLException {
    return PedidoDAO.obterPedidosComanda(idComanda);
  }
  */
  public Prato obterPrato(Integer idPrato)
          throws ClassNotFoundException, SQLException {
    return PratoDAO.getInstancia().findById(idPrato);
  }

  public Comanda obterComanda(Integer idComanda)
          throws ClassNotFoundException, SQLException {
    return ComandaDAO.getInstancia().findById(idComanda);
  }

  public void gravar()
          throws SQLException, ClassNotFoundException {
    PedidoDAO.getInstancia().save(this);
  }

  public void editar()
          throws SQLException, ClassNotFoundException {
    PedidoDAO.getInstancia().save(this);
  }

  public void excluir()
          throws ClassNotFoundException, SQLException {
    PedidoDAO.getInstancia().remove(this.id);
  }
}
