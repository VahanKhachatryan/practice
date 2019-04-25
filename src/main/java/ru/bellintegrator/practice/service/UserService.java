package ru.bellintegrator.practice.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.model.User;
import ru.bellintegrator.practice.util.MockDataUtil;

/**
 * Service class - UserService
 */
@Service
public class UserService {
    /**
     * User return method
     */
    public User getUser() {
        return MockDataUtil.getUser();
    }
}
