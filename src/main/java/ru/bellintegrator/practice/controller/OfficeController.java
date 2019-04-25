package ru.bellintegrator.practice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.OfficeService;

/**
 * Office controller
 * This  rest controller is responsible for all the methods for the model: "Office"
 */
@RestController
@RequestMapping(value = "/api")
public class OfficeController {
    private OfficeService officeService = new OfficeService();

    /**
     * This method returns all offices
     */
    @GetMapping(value = "/office")
    @ApiOperation(value = "Get office")
    public ResponseEntity getOffice() {
        return ResponseEntity.ok(officeService.getOffice());
    }


}
