package ru.bellintegrator.practice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.DocumentService;

/**
 * Document controller
 * This  rest controller is responsible for all the methods for the model: "Document    "
 */
@RestController
@RequestMapping(value = "/api")
public class DocumentController {
    private DocumentService documentService = new DocumentService();

    /**
     * This method returns all documents
     */
    @GetMapping(value = "/document")
    @ApiOperation(value = "Get document")
    public ResponseEntity getDoc() {
        return ResponseEntity.ok(documentService.getDocument());
    }

}
