package ru.bellintegrator.practice.dao.document;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * DocumentDaoImpl
 */
@Repository
public class DocumentDaoImpl implements DocumentDao {
    private final EntityManager manager;

    public DocumentDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Document> all() {
        TypedQuery<Document> query = manager.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }


}
