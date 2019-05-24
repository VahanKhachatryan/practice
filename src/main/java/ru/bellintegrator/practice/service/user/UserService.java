package ru.bellintegrator.practice.service.user;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.model.User;
import ru.bellintegrator.practice.view.UserView;

import java.util.List;

@Validated
public interface UserService {
    List<UserView> getUser(int officeId, String firstName, String lastName, String middleName,
                           String position, String docCode, String countryCode);

    UserView getById(int id);

    int update(UserView user);

    void add(UserView userView);

}
