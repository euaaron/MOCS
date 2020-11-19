/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Usuario;

public class UsuarioDAO {

    private static UsuarioDAO instancia = new UsuarioDAO();

  private UsuarioDAO() {
  }

  public static UsuarioDAO getInstancia() {
    return instancia;
  }
  
  public Usuario save(Usuario entity) {
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

  public Usuario remove(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Usuario entity = null;
    try {
      entity = em.find(Usuario.class, id);
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

  public List<Usuario> findAll() {
    EntityManager em = new ConexaoFactory().getConexao();
    List<Usuario> entities = null;
    try {
      entities = em.createQuery("from Usuario c").getResultList();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entities;
  }

  public Usuario findById(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    Usuario entity = null;
    try {
      entity = em.find(Usuario.class, id);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }
}
