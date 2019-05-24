package ru.bellintegrator.practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.country.CountryService;
import ru.bellintegrator.practice.view.CountryView;

import java.util.List;

/**
 * Country controller
 */
@Api(value = "CountryController", description = "Управление информацией о странах")
@RestController
@RequestMapping(value = "/api")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * This method returns all countries
     */
    @ApiOperation(value = "Get all countries", httpMethod = "GET")
    @GetMapping("/countries")
    public ResponseEntity<List<CountryView>> countries() {
        List<CountryView> countries = countryService.countries();
        return ResponseEntity.ok(countries);

    }
}
