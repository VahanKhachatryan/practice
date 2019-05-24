package ru.bellintegrator.practice.dao.country;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * CountryDaoImpl
 */
@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager manager;

    public CountryDaoImpl(EntityManager manager) {
        this.manager = manager;
    }



    @Override
    public List<Country> all() {
        TypedQuery<Country> query = manager.createQuery("SELECT c FROM Country c", Country.class);

        return query.getResultList();
    }


}
