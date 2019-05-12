package ru.bellintegrator.practice.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

@Validated
public interface OrganizationService {
    List<OrganizationView> getOrgList(String name, String inn, Boolean isActive);

    OrganizationView getOrgById(int id);

    void update(OrganizationView organizationView);

    void add(OrganizationView organizationView);


}
