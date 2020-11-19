/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Estabelecimento;

public class EstabelecimentoDAO {

    private static EstabelecimentoDAO instancia = new EstabelecimentoDAO();

  private EstabelecimentoDAO() {
  }

  public static EstabelecimentoDAO getInstancia() {
    return instancia;
  }
  
  public Estabelecimento save(Estabelecimento entity) {
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

  public Estabelecimento remove(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Estabelecimento entity = null;
    try {
      entity = em.find(Estabelecimento.class, id);
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

  public List<Estabelecimento> findAll() {
    EntityManager em = new ConexaoFactory().getConexao();
    List<Estabelecimento> entities = null;
    try {
      entities = em.createQuery("from Estabelecimento c").getResultList();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entities;
  }

  public Estabelecimento findById(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Estabelecimento entity = null;
    try {
      entity = em.find(Estabelecimento.class, id);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }
}
