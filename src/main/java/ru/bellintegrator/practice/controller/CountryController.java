package ru.bellintegrator.practice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.CountryService;

/**
 * Country controller
 * This  rest controller is responsible for all the methods for the model: "Country"
 */
@RestController
@RequestMapping(value = "/api")
public class CountryController {
    private CountryService countryService = new CountryService();

    /**
     * This method returns all countries
     */
    @GetMapping(value = "/country")
    @ApiOperation(value = "Get country")
    public ResponseEntity getCountry() {
        return ResponseEntity.ok(countryService.getCountry());
    }

}
