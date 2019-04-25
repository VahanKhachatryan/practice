package ru.bellintegrator.practice.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.util.MockDataUtil;

/**
 * Service class - OrganizationService
 */
@Service
public class OrganizationService {
    /**
     * Office return method
     */
    public Organization getOrganization() {
        return MockDataUtil.getOrganization();
    }
}
