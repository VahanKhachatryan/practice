package ru.bellintegrator.practice.service.country;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.country.CountryDao;
import ru.bellintegrator.practice.model.Country;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.CountryView;

import java.util.List;

/**
 * Service class - CountryService
 */
@Service
@Transactional(readOnly = true)
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;

    public CountryServiceImpl(CountryDao countryDao, MapperFacade mapperFacade) {
        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
    }


    @Override
    public List<CountryView> countries() {
        List<Country> all = countryDao.all();
        return mapperFacade.mapAsList(all, CountryView.class);
    }
}
