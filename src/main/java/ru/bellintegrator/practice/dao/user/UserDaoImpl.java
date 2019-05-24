package ru.bellintegrator.practice.dao.user;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.User;
import ru.bellintegrator.practice.view.UserView;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager manager;

    public UserDaoImpl(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public List<User> findAll(int officeId, String firstName, String lastName, String middleName, String position,
                              String docCode, String countryCode) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.where(builder.equal(root.get("office").get("id"), officeId));

        criteriaQuery.where(root.get("officeId").in(officeId));
        if (firstName != null) {
            criteriaQuery.where(root.get("firstName").in(firstName));
        }
        if (lastName != null) {
            criteriaQuery.where(root.get("lastName").in(lastName));
        }
        if (middleName != null) {
            criteriaQuery.where(root.get("middleName").in(middleName));
        }
        if (position != null) {
            criteriaQuery.where(root.get("position").in(position));
        }
        if (docCode != null) {
            criteriaQuery.where(builder.equal(root.get("document").get("code"), countryCode));
        }
        if (countryCode != null) {
            criteriaQuery.where(builder.equal(root.get("country").get("code"), countryCode));
        }

        criteriaQuery.select(builder.construct(User.class,
                root.get("officeId"), root.get("firstName"), root.get("lastName"), root.get("middleName"),
                root.get("position"), root.get("documentId"), root.get("countryCode")));
        TypedQuery<User> query = manager.createQuery(criteriaQuery);
        return query.getResultList();

    }

    @Override
    public User findById(int id) {
        return manager.find(User.class, id);

    }

    @Override
    public int update(UserView user) {
        Query query = manager.createQuery("UPDATE User us" +
                " SET us.country = :country," +
                " us.document= :document," +
                "us.office = :office," +
                "us.firstName = :firstName," +
                "us.middleName = :middleName," +
                "us.secondName = :secondName," +
                "us.position = :position," +
                "us.phone = :phone," +
                "us.isIdentified = :isIdentified" +
                " WHERE us.id = :id ");
        query.setParameter("id", user.getId());
        query.setParameter("country", user.getCountry());
        query.setParameter("document", user.getDocument());
        query.setParameter("office", user.getOffice());
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("middleName", user.getMiddleName());
        query.setParameter("secondName", user.getSecondName());
        query.setParameter("position", user.getPosition());
        query.setParameter("phone", user.getPhone());
        query.setParameter("isIdentified", user.getIsIdentified());
        int result = query.executeUpdate();
        return result;
    }

    @Override
    public void save(User user) {
        manager.persist(user);
    }
}
