/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Prato;

public class PratoDAO {
    private static PratoDAO instancia = new PratoDAO();

  private PratoDAO() {
  }

  public static PratoDAO getInstancia() {
    return instancia;
  }
  
  public Prato save(Prato entity) {
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

  public Prato remove(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Prato entity = null;
    try {
      entity = em.find(Prato.class, id);
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

  public List<Prato> findAll() {
    EntityManager em = new ConexaoFactory().getConexao();
    List<Prato> entities = null;
    try {
      entities = em.createQuery("from Prato c").getResultList();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entities;
  }

  public Prato findById(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Prato entity = null;
    try {
      entity = em.find(Prato.class, id);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }
}
