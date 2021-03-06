/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Comanda;

public class ComandaDAO {

  private static ComandaDAO instancia = new ComandaDAO();

  private ComandaDAO() {
  }

  public static ComandaDAO getInstancia() {
    return instancia;
  }
  
  public Comanda save(Comanda comanda) {
    EntityManager em = new ConexaoFactory().getConexao();
    try {
      em.getTransaction().begin();
      if (comanda.getId() == null) {
        em.persist(comanda);
      } else {
        em.merge(comanda);
      }
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      System.err.println(e);
    } finally {
      em.close();
    }
    return comanda;
  }

  public Comanda remove(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Comanda entity = null;
    try {
      entity = em.find(Comanda.class, id);
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

  public List<Comanda> findAll() {
    EntityManager em = new ConexaoFactory().getConexao();
    List<Comanda> entities = null;
    try {
      entities = em.createQuery("from comanda c").getResultList();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entities;
  }

  public Comanda findById(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Comanda entity = null;
    try {
      entity = em.find(Comanda.class, id);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }
}
