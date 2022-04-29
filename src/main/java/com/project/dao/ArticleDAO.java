package com.project.dao;

import com.project.entity.ArticleEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDAO {

    private List<ArticleEntity> articles;

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

    public List<ArticleEntity> index() {
        final EntityManager entityManager = getManager();

        entityManager.getTransaction().begin();
        articles = entityManager.createQuery("FROM ArticleEntity").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return articles;
    }

    public void add(ArticleEntity article) {
        final EntityManager entityManager = getManager();

        entityManager.getTransaction().begin();
        entityManager.merge(article);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public ArticleEntity showArticle(int id) {
        return articles.stream().filter(articles -> articles.getId() == id).findAny().orElse(null);
    }

    public void update(int id, String name, String topic, String txt) {
        final EntityManager entityManager = getManager();
        entityManager.getTransaction().begin();
        ArticleEntity article=entityManager.find(ArticleEntity.class,id);

        article.setName(name);
        article.setTopic(topic);
        article.setText(txt);

        entityManager.persist(article);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(int id) {
        final EntityManager entityManager = getManager();
        ArticleEntity article= showArticle(id);

        entityManager.getTransaction().begin();
        entityManager.remove(article);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
