package ru.bellintegrator.practice.service.country;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.view.CountryView;

import java.util.List;

@Validated
public interface CountryService {
    List<CountryView> countries();

}
