package ru.bellintegrator.practice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.OrganizationService;

/**
 * Organization controller
 * This  rest controller is responsible for all the methods for the model: "Organization"
 */
@RestController
@RequestMapping(value = "/api")
public class OrganizationController {
    private OrganizationService organizationService = new OrganizationService();

    /**
     * This method returns all organizations
     */
    @GetMapping(value = "/organization")
    @ApiOperation(value = "Get organization")
    public ResponseEntity getOrganization() {
        return ResponseEntity.ok(organizationService.getOrganization());
    }

}
