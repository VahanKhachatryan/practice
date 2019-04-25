package ru.bellintegrator.practice.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.util.MockDataUtil;

/**
 * Service class - OfficeService
 */
@Service
public class OfficeService {
    /**
     * Office return method
     */
    public Office getOffice() {
        return MockDataUtil.getOffice();
    }
}
