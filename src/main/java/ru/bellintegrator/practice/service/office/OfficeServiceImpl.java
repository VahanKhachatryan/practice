package ru.bellintegrator.practice.service.office;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.office.OfficeDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OfficeView;

import java.util.List;

/**
 * Service class - OfficeService
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }


    @Override
    public OfficeView getOfficeList(String name, String phone, Boolean isActive) {
        List<Office> all = officeDao.findAll(name, phone, isActive);
        return mapperFacade.map(all, OfficeView.class);
    }

    @Override
    public OfficeView getOfficeById(int id) {
        return mapperFacade.map(officeDao.findById(id), OfficeView.class);
    }

    @Override
    @Transactional
    public int update(OfficeView office) {
        return officeDao.update(office);
    }

    @Override
    @Transactional
    public void add(OfficeView officeView) {
        Office office = new Office(officeView.name, officeView.address, officeView.phone, officeView.isActive);
        officeDao.save(office);

    }
}
