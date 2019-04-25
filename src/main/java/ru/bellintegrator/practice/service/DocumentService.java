package ru.bellintegrator.practice.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.util.MockDataUtil;

/**
 * Service class - DocumentService
 */
@Service
public class DocumentService {
    /**
     * Document return method
     */
    public Document getDocument() {
        return MockDataUtil.getDocument();
    }
}
