package ru.bellintegrator.practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.organization.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Organization controller
 * This  rest controller is responsible for findAllByOrgNameAndInnAndIsActive the methods for the model: "Organization"
 */
@Api(value = "OrganizationController", description = "Управление информацией об организации")
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Добавить новую организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity organization(@RequestBody OrganizationView organizationView) {
        organizationService.add(organizationView);
        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "Получить список всех организации", httpMethod = "GET")
    @PostMapping("/list")
    public ResponseEntity<List<OrganizationView>> organizations(@RequestParam(name = "name") String name,
                                                                @RequestParam(name = "inn") String inn,
                                                                @RequestParam(name = "isActive") Boolean isActive) {
        List<OrganizationView> organizations = organizationService.getOrgList(name, inn, isActive);
        return ResponseEntity.ok(organizations);

    }

    @ApiOperation(value = "Получить список всех организации", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationView> organizationById(@PathVariable("id") int id) {
        OrganizationView orgById = organizationService.getOrgById(id);
        return ResponseEntity.ok(orgById);

    }
}
