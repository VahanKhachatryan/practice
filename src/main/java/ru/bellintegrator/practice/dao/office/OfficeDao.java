package ru.bellintegrator.practice.dao.office;

import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.OfficeView;

import java.util.List;

public interface OfficeDao {
    List<Office> findAll(String name, String phone, Boolean isActive);

    Office findById(int id);

    int update(OfficeView officeView);

    void save(Office office);
}
