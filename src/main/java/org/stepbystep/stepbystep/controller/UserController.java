package org.stepbystep.stepbystep.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.stepbystep.stepbystep.model.Task;
import org.stepbystep.stepbystep.model.User;
import org.stepbystep.stepbystep.service.UserService;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}/tasks")
    public List<Task> getUserTasks(@PathVariable int id) throws Exception {
        return userService.getTasksByUserId(id);
    }
}
