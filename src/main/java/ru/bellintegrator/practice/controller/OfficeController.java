package ru.bellintegrator.practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.exception.ThereIsNoSuchElementException;
import ru.bellintegrator.practice.service.office.OfficeService;
import ru.bellintegrator.practice.view.OfficeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Office controller
 */
@Api(value = "OfficeController", description = "Управление информацией об оффисах")
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * This method add Office
     */
    @ApiOperation(value = "Add office", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity office(@RequestBody OfficeView officeView) {
        if (officeView==null){
            throw new ThereIsNoSuchElementException();
        }
        officeService.add(officeView);
        return ResponseEntity.status(HttpStatus.OK).body(officeView.name);
    }

    /**
     * This method return office by parameters
     */
    @ApiOperation(value = "Get office by parameters", httpMethod = "GET")
    @PostMapping("/list")
    public ResponseEntity<List<OfficeView>> offices(@RequestParam String name,
                                                    @RequestParam String phone,
                                                    @RequestParam Boolean isActive) {
        List<OfficeView> officeList = officeService.getOfficeList(name, phone, isActive);
        if (officeList==null){
            throw new ThereIsNoSuchElementException();
        }
        return ResponseEntity.ok(officeList);

    }

    /**
     * This method return office by id
     */
    @ApiOperation(value = "Get office by id", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<OfficeView> officeById(@PathVariable("id") int id) {
        OfficeView officeById = officeService.getOfficeById(id);
        if (officeById==null){
            throw new ThereIsNoSuchElementException();
        }
        return ResponseEntity.ok(officeById);
    }

    /**
     * This method return update of the office details
     */
    @PutMapping(value = "/update")
    @ApiOperation(value = "The update of the office details", tags = "Office")
    public ResponseEntity updateOffice(@RequestBody OfficeView office) {
        if (office==null){
            throw new ThereIsNoSuchElementException();
        }
        officeService.update(office);
        return ResponseEntity.ok("update");
    }


}
