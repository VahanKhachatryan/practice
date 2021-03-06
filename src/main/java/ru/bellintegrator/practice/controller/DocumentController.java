package ru.bellintegrator.practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.exception.ThereIsNoSuchElementException;
import ru.bellintegrator.practice.service.document.DocumentService;
import ru.bellintegrator.practice.view.DocumentView;

import java.util.List;

/**
 * Document controller
 */
@Api(value = "DocumentController", description = "Управление информацией о документах")
@RestController
@RequestMapping(value = "/api")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    /**
     * This method returns all documents
     */
    @ApiOperation(value = "Get all documents", httpMethod = "GET")
    @GetMapping("/documents")
    public ResponseEntity<List<DocumentView>> documents() {
        List<DocumentView> documents = documentService.documents();
        if (documents==null){
            throw new ThereIsNoSuchElementException();
        }
        return ResponseEntity.ok(documents);

    }

}
