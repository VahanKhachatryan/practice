package ru.bellintegrator.practice.dao.organization;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.OrganizationView;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager manager;

    public OrganizationDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Organization> findAllByOrgNameAndInnAndIsActive(String name, String inn, Boolean isActive) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);
        Root<Organization> root = criteriaQuery.from(Organization.class);
        criteriaQuery.where(root.get("name").in(name));
        if (inn != null) {
            criteriaQuery.where(root.get("inn").in(inn));
        }
        if (isActive != null) {
            criteriaQuery.where(root.get("isActive").in(isActive));
        }
        criteriaQuery.select(builder.construct(Organization.class,
                root.get("name"), root.get("inn"), root.get("isActive")));
        TypedQuery<Organization> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Organization findById(int id) {
        return manager.find(Organization.class, id);
    }

    @Override
    public int update(OrganizationView organization) {
        Query query = manager.createQuery("UPDATE Organization org" +
                " SET org.name = :name," +
                " org.fullName = :fullName," +
                " org.inn = :inn," +
                " org.kpp = :kpp," +
                " org.address = :address," +
                " org.phone = :phone," +
                "org.isActive = :isActive" +
                " WHERE org.id = :id ");
        query.setParameter("id", organization.getId());
        query.setParameter("name", organization.getName());
        query.setParameter("fullName", organization.getFullName());
        query.setParameter("inn", organization.getInn());
        query.setParameter("kpp", organization.getKpp());
        query.setParameter("address", organization.getAddress());
        query.setParameter("phone", organization.getPhone());
        query.setParameter("isActive", organization.getIsActive());
        int result = query.executeUpdate();
        return result;
    }


    @Override
    public void save(Organization organization) {
        manager.persist(organization);
    }
}
