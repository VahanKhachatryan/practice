package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.model.Organization;

import java.util.List;

public interface OrganizationDao {
    List<Organization> findAllByOrgNameAndInnAndIsActive(String name,String inn,Boolean isActive);

    Organization findById(int id);

    //todo
    void update(Organization organization);

    void save(Organization organization);
}
