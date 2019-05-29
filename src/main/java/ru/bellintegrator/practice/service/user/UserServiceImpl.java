package ru.bellintegrator.practice.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.user.UserDao;
import ru.bellintegrator.practice.model.User;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.UserView;

import java.util.List;

/**
 * Service class - UserService
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final MapperFacade mapperFacade;
    private final UserDao userDao;

    public UserServiceImpl(MapperFacade mapperFacade, UserDao userDao) {
        this.mapperFacade = mapperFacade;
        this.userDao = userDao;
    }

    @Override
    public List<UserView> getUser(int officeId, String firstName,
                                  String middleName, String secondName, String position, String docCode, String countryCode) {
        List<User> users = userDao.findAll(officeId, firstName,  middleName,secondName, position, docCode, countryCode);
        return mapperFacade.mapAsList(users, UserView.class);
    }

    @Override
    public UserView getById(int id) {
        return mapperFacade.map(userDao.findById(id), UserView.class);
    }

    @Override
    @Transactional
    public int update(UserView user) {
        return userDao.update(user);
    }

    @Override
    @Transactional
    public void add(UserView userView) {
        User user = new User(userView.country, userView.document, userView.office, userView.firstName, userView.middleName,
                userView.secondName, userView.position, userView.phone, userView.isIdentified);
        userDao.save(user);
    }
}
