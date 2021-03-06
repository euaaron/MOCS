/**
 *
 * @project Project MOCS
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.ComandaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comanda {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String data;
  private String hora;
  @ManyToOne
  private Usuario usuario = null;
  private Integer idCliente;

  public Comanda(Integer id, String dataComanda, String horaComanda, Integer idCliente) {
    this.data = dataComanda;       // O Marco pediu para não trabalharmos com
    this.hora = horaComanda;       // data e hora no momento... apenas com
    this.idCliente = idCliente;    // atributos básicos, como int, string e float.
    this.id = id;
  }

// Métodos de inserção (Modificação)
  public void setId(Integer id) {
    this.id = id;
  }

  public void setData(String dataComanda) {
    this.data = dataComanda;
  }

  public void setHora(String horaComanda) {
    this.hora = horaComanda;
  }

  public void setCliente(Usuario cliente) {
    this.usuario = cliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

// Métodos de Recuperação (Leitura)    
  public Integer getId() {
    return id;
  }

  public String getData() {
    return data;
  }

  public String getHora() {
    return hora;
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public Usuario getCliente()
          throws ClassNotFoundException, SQLException {
    if ((idCliente != 0) && (usuario == null)) {
      usuario = Usuario.obterUsuario(idCliente);
    }
    return usuario;
  }

// Métodos de comunicação com a camada DAO (Banco de dados)
  public static Comanda obterComanda(Integer idComanda)
          throws ClassNotFoundException, SQLException {
    return ComandaDAO.getInstancia().findById(idComanda);
  }

  public float obterTotal() throws ClassNotFoundException, SQLException {
    List<Pedido> pedidos = Pedido.obterPedidos();
    float total = 0;
    for (int i = 0; i < pedidos.size(); i++) {
      Pedido pedido = pedidos.get(i);
      if (pedido.getIdComanda().equals(this.id)) {
        total += pedido.getQuantidade() * Prato.obterPrato(pedido.getIdPrato()).
                getPreco();
      }
    }
    return total;
  }

  public int numPedidos() throws ClassNotFoundException, SQLException {
    List<Pedido> pedidos = Pedido.obterPedidos();
    int cont = 0;
    for (int i = 0; i < pedidos.size(); i++) {
      Pedido pedido = pedidos.get(i);
      if (pedido.getIdComanda().equals(this.id)) {
        cont++;
      }
    }
    return cont;
  }

  public static List<Comanda> obterComandas()
          throws ClassNotFoundException, SQLException {
    return ComandaDAO.getInstancia().findAll();
  }

// Métodos de comunicação com a camada DAO (Banco de dados)
  public Usuario obterCliente()
          throws ClassNotFoundException, SQLException {
    return Usuario.obterUsuario(idCliente);
  }

  public void gravar()
          throws SQLException, ClassNotFoundException {
    ComandaDAO.getInstancia().save(this);
  }

  public void editar()
          throws SQLException, ClassNotFoundException {
    ComandaDAO.getInstancia().save(this);
  }

  public void excluir()
          throws ClassNotFoundException, SQLException {
    ComandaDAO.getInstancia().remove(this.id);
  }
}
