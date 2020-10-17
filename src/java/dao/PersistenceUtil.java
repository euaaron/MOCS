package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aaron
 */
public class PersistenceUtil {

    private static EntityManagerFactory emf = null;

    private PersistenceUtil() {
    }

    public static EntityManager getEntityManager() {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("heroku_7a4577ab47d8311");
        return emf.createEntityManager();
    }

    public static void close(EntityManager em) {
        if (em != null)
            em.close();
    }

}
