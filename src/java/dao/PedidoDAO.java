/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Pedido;

public class PedidoDAO {
    private static PedidoDAO instancia = new PedidoDAO();

  private PedidoDAO() {
  }

  public static PedidoDAO getInstancia() {
    return instancia;
  }
  
  public Pedido save(Pedido entity) {
    EntityManager em = new ConexaoFactory().getConexao();
    try {
      em.getTransaction().begin();
      if (entity.getId() == null) {
        em.persist(entity);
      } else {
        em.merge(entity);
      }
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }

  public Pedido remove(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Pedido entity = null;
    try {
      entity = em.find(Pedido.class, id);
      em.getTransaction().begin();
      em.remove(entity);
      em.getTransaction().commit();
    } catch (Exception ex) {
      em.getTransaction().rollback();
      System.err.println(ex);
    } finally {
      em.close();
    }
    return entity;
  }

  public List<Pedido> findAll() {
    EntityManager em = new ConexaoFactory().getConexao();
    List<Pedido> entities = null;
    try {
      entities = em.createQuery("from Pedido c").getResultList();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entities;
  }

  public Pedido findById(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Pedido entity = null;
    try {
      entity = em.find(Pedido.class, id);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }
}