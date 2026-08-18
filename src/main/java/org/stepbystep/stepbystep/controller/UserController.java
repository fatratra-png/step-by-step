package org.stepbystep.stepbystep.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stepbystep.stepbystep.model.User;
import org.stepbystep.stepbystep.service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception {
        return userService.getAllUsers();
    }
}
