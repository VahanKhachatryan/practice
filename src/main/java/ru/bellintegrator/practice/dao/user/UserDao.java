package ru.bellintegrator.practice.dao.user;

import ru.bellintegrator.practice.model.User;
import ru.bellintegrator.practice.view.UserView;

import java.util.List;

public interface UserDao {
    List<User> findAll(int officeId, String firstName, String secondName, String middleName,
                       String position, String docCode, String countryCode);

    User findById(int id);

    int update(UserView user);

    void save(User user);

}
