package ru.bellintegrator.practice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.UserService;

/**
 * User controller
 * This  rest controller is responsible for all the methods for the model: "User"
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {
    private UserService userService = new UserService();

    /**
     * This method returns all users
     */
    @GetMapping(value = "/user")
    @ApiOperation(value = "Get user")
    public ResponseEntity getUser() {
        return ResponseEntity.ok(userService.getUser());
    }

}
