package ru.bellintegrator.practice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.user.UserService;
import ru.bellintegrator.practice.view.UserView;

import java.util.List;

/**
 * User controller
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This method add new User
     */
    @ApiOperation(value = "Add new user", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity user(@RequestBody UserView userView) {
        userService.add(userView);
        return ResponseEntity.status(HttpStatus.OK).body(userView.firstName);
    }

    /**
     * This method return user by parameters
     */
    @ApiOperation(value = "Get user by parameters", httpMethod = "GET")
    @PostMapping("/list")
    public ResponseEntity<List<UserView>> users(@RequestParam(name = "officeId") int officeId,
                                                @RequestParam(name = "firstName") String firstName,
                                                @RequestParam(name = "lastName") String lastName,
                                                @RequestParam(name = "middleName") String middleName,
                                                @RequestParam(name = "position") String position,
                                                @RequestParam(name = "documentId") String docId,
                                                @RequestParam(name = "countryId") String countryId) {
        List<UserView> userViews = userService.getUser(officeId, firstName, lastName, middleName,
                position, docId, countryId);
        return ResponseEntity.ok(userViews);

    }

    /**
     * This method return user by id
     */
    @ApiOperation(value = "Get user by id", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<UserView> userById(@PathVariable("id") int id) {
        UserView byId = userService.getById(id);
        return ResponseEntity.ok(byId);
    }

    /**
     * This method update of the office details
     */
    @PutMapping(value = "/update")
    @ApiOperation(value = "The update of the User details", tags = "Office")
    public ResponseEntity updateUser(@RequestBody UserView user) {
        userService.update(user);
        return ResponseEntity.ok(user);
    }

}
