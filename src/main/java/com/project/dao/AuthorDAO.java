package com.project.dao;

import com.project.entity.AuthorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorDAO {
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


    public List<AuthorEntity> index() {
        final EntityManager entityManager = getManager();

        entityManager.getTransaction().begin();
        List list = entityManager.createQuery("FROM AuthorEntity").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;

    }
}
