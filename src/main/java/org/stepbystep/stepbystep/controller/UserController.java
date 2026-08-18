package org.stepbystep.stepbystep.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stepbystep.stepbystep.model.Step;
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

    @GetMapping("/users/{userId}/tasks/{taskId}/steps")
    public List<Step> getTaskSteps(@PathVariable int userId,
                                   @PathVariable int taskId,
                                   @RequestParam boolean isCompleted) throws Exception {
        return userService.getStepsByTaskId(userId, taskId, isCompleted);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user.userName());
    }
}
