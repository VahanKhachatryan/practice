package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

public interface OrganizationDao {
    List<Organization> findAllByOrgNameAndInnAndIsActive(String name,String inn,Boolean isActive);

    Organization findById(int id);

    int update(OrganizationView organization);

    void save(Organization organization);
}
