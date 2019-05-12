package ru.bellintegrator.practice.service.document;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.view.DocumentView;

import java.util.List;

@Validated
public interface DocumentService {
    List<DocumentView> documents();
}
