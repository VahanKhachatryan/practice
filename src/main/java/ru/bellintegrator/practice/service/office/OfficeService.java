package ru.bellintegrator.practice.service.office;

import ru.bellintegrator.practice.view.OfficeView;

import java.util.List;

public interface OfficeService {
    List<OfficeView> getOfficeList(String name, String phone, Boolean isActive);

    OfficeView getOfficeById(int id);

    int update(OfficeView office);

    void add(OfficeView officeView);
}
