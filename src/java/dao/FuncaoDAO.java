package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Funcao;

public class FuncaoDAO {

    private static FuncaoDAO instancia = new FuncaoDAO();

  private FuncaoDAO() {
  }

  public static FuncaoDAO getInstancia() {
    return instancia;
  }
  
  public Funcao save(Funcao entity) {
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

  public Funcao remove(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Funcao entity = null;
    try {
      entity = em.find(Funcao.class, id);
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

  public List<Funcao> findAll() {
    EntityManager em = new ConexaoFactory().getConexao();
    List<Funcao> entities = null;
    try {
      entities = em.createQuery("from Funcao c").getResultList();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entities;
  }

  public Funcao findById(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Funcao entity = null;
    try {
      entity = em.find(Funcao.class, id);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }
}
