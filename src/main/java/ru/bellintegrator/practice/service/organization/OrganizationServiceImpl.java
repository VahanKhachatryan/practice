package ru.bellintegrator.practice.service.organization;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

/**
 * Service class - OrganizationService
 */
@Service
@Transactional(readOnly = true)
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<OrganizationView> getOrgList(String name, String inn, Boolean isActive) {
        List<Organization> organizations = organizationDao.findAllByOrgNameAndInnAndIsActive(name, inn, isActive);
        return mapperFacade.mapAsList(organizations, OrganizationView.class);
    }

    @Override
    public OrganizationView getOrgById(int id) {
        return mapperFacade.map(organizationDao.findById(id), OrganizationView.class);
    }

    @Override
    @Transactional
    public int update(OrganizationView organizationView) {
        return organizationDao.update(organizationView);
    }

    @Override
    @Transactional
    public void add(OrganizationView organizationView) {
        Organization organization = new Organization(organizationView.name, organizationView.fullName,
                organizationView.inn, organizationView.kpp, organizationView.address, organizationView.phone,
                organizationView.isActive, organizationView.offices);
        organizationDao.save(organization);
    }
}
