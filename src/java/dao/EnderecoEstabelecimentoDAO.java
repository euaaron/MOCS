/**
 * Project MOCS
 *
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.EnderecoEstabelecimento;

public class EnderecoEstabelecimentoDAO {

    private static EnderecoEstabelecimentoDAO instancia = new EnderecoEstabelecimentoDAO();

  private EnderecoEstabelecimentoDAO() {
  }

  public static EnderecoEstabelecimentoDAO getInstancia() {
    return instancia;
  }
  
  public EnderecoEstabelecimento save(EnderecoEstabelecimento entity) {
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

  public EnderecoEstabelecimento remove(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    EnderecoEstabelecimento entity = null;
    try {
      entity = em.find(EnderecoEstabelecimento.class, id);
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

  public List<EnderecoEstabelecimento> findAll() {
    EntityManager em = new ConexaoFactory().getConexao();
    List<EnderecoEstabelecimento> entities = null;
    try {
      entities = em.createQuery("from EnderecoEstabelecimento c").getResultList();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entities;
  }

  public EnderecoEstabelecimento findById(Integer id) {
    EntityManager em = new ConexaoFactory().getConexao();
    EnderecoEstabelecimento entity = null;
    try {
      entity = em.find(EnderecoEstabelecimento.class, id);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      em.close();
    }
    return entity;
  }

}
