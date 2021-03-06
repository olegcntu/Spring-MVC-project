import com.project.entity.ArticleEntity;
import com.project.entity.ReaderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ENTITY_MANAGER_FACTORY = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getManager() throws HibernateException {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void main(final String[] args) throws Exception {
       ReaderEntity article= new ReaderEntity();


        final EntityManager entityManager = getManager();

        entityManager.getTransaction().begin();
        entityManager.merge(article);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}