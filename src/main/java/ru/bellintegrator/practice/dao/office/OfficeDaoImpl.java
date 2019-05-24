package ru.bellintegrator.practice.dao.office;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.OfficeView;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {
    private final EntityManager manager;

    public OfficeDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Office> findAll(String name, String phone, Boolean isActive) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);
        Root<Office> root = criteriaQuery.from(Office.class);
        criteriaQuery.where(root.get("name").in(name));
        if (phone != null) {
            criteriaQuery.where(root.get("phone").in(phone));
        }
        if (isActive != null) {
            criteriaQuery.where(root.get("isActive").in(isActive));
        }
        criteriaQuery.select(builder.construct(Office.class,
                root.get("name"), root.get("phone"), root.get("isActive")));
        TypedQuery<Office> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Office findById(int id) {
        return manager.find(Office.class, id);
    }

    @Override
    public int update(OfficeView office) {
        Query query = manager.createQuery("UPDATE Office off" +
                " SET off.name = :name," +
                " off.address = :address," +
                " off.phone = :phone," +
                "off.isActive = :isActive" +
                " WHERE off.id = :id ");
        query.setParameter("id", office.getId());
        query.setParameter("name", office.getName());
        query.setParameter("address", office.getAddress());
        query.setParameter("phone", office.getPhone());
        query.setParameter("isActive", office.getIsActive());
        int result = query.executeUpdate();
        return result;
    }

    @Override
    public void save(Office office) {
        manager.persist(office);
    }
}
