import com.project.entity.AuthorEntity;
import com.project.models.Author;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.EntityType;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;
import java.util.Map;

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

    public static EntityManager getSession() throws HibernateException {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void main(final String[] args) throws Exception {
        final EntityManager entityManager = getSession();

        entityManager.getTransaction().begin();
        List list = entityManager.createQuery("FROM ArticleEntity").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(list.get(0));

    }
}