package ru.bellintegrator.practice.service.document;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.document.DocumentDao;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.DocumentView;

import java.util.List;

/**
 * Service class - DocumentService
 */
@Service
@Transactional(readOnly = true)
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;
    private final MapperFacade mapperFacade;

    public DocumentServiceImpl(DocumentDao documentDao, MapperFacade mapperFacade) {
        this.documentDao = documentDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<DocumentView> documents() {
        List<Document> all = documentDao.all();
        return mapperFacade.mapAsList(all, DocumentView.class);
    }
}
