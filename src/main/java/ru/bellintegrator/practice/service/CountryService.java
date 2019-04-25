package ru.bellintegrator.practice.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.model.Country;
import ru.bellintegrator.practice.util.MockDataUtil;

/**
 * Service class - CountryService
 */
@Service
public class CountryService {
    /**
     * Country return method
     */
    public Country getCountry() {
        return MockDataUtil.getCountry();
    }
}
