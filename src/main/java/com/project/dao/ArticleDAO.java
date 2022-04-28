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

//    public void update(int id, String name, String topic, String txt) {
//        Article updateArticle = this.showArticle(id);
//        updateArticle.setName(name);
//        updateArticle.setTopic(topic);
//        updateArticle.setTxt(txt);
//    }

//    public void delete(int id){
//        articles.remove(showArticle(id));
//    }
}
