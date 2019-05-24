package ru.bellintegrator.practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.organization.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Organization controller
 */
@Api(value = "OrganizationController", description = "Управление информацией об организации")
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * This method add Organization
     */
    @ApiOperation(value = "Add organization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity organization(@RequestBody OrganizationView organizationView) {
        organizationService.add(organizationView);
        return ResponseEntity.status(HttpStatus.OK).body(organizationView.name);
    }

    /**
     * This method return organization by parameter
     */
    @ApiOperation(value = "Get organization by parameter", httpMethod = "POST")
    @PostMapping("/list")
    public ResponseEntity<List<OrganizationView>> organizations(@RequestParam(name = "name") String name,
                                                                @RequestParam(name = "inn") String inn,
                                                                @RequestParam(name = "isActive") Boolean isActive) {
        List<OrganizationView> organizations = organizationService.getOrgList(name, inn, isActive);
        return ResponseEntity.ok(organizations);

    }


    /**
     * This method return organization by Id
     */
    @ApiOperation(value = "Get organization by Id", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationView> organizationById(@PathVariable("id") int id) {
        OrganizationView orgById = organizationService.getOrgById(id);
        return ResponseEntity.ok(orgById);


    }

    /**
     * This method return update of the organization details
     */
    @PutMapping(value = "/update")
    @ApiOperation(value = "The update of the organization details", tags = "Organization")
    public ResponseEntity updateOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.update(organizationView);
        return ResponseEntity.ok(organizationView);
    }
}
