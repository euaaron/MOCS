/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Funcionario;

public class FuncionarioDAO {
    
    private static FuncionarioDAO instancia = new FuncionarioDAO();

  private FuncionarioDAO() {
  }

  public static FuncionarioDAO getInstancia() {
    return instancia;
  }
  
  public Funcionario save(Funcionario entity) {
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

  public Funcionario remove(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Funcionario entity = null;
    try {
      entity = em.find(Funcionario.class, id);
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

  public List<Funcionario> findAll() {
    EntityManager em = new ConexaoFactory().getConexao();
    List<Funcionario> entities = null;
    try {
      entities = em.createQuery("from Funcionario c").getResultList();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entities;
  }

  public Funcionario findById(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Funcionario entity = null;
    try {
      entity = em.find(Funcionario.class, id);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }
}
