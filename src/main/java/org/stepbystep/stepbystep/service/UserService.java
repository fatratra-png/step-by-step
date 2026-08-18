package org.stepbystep.stepbystep.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.stepbystep.stepbystep.model.Step;
import org.stepbystep.stepbystep.model.Task;
import org.stepbystep.stepbystep.model.User;
import org.stepbystep.stepbystep.repository.TaskRepository;
import org.stepbystep.stepbystep.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    public List<Task> getTasksByUserId(int userId) throws Exception {
        return taskRepository.findByUserId(userId);
    }

    public List<Step> getStepsByTaskId(int userId, int taskId, boolean isCompleted) throws Exception {
        if (!taskRepository.existsByIdAndUserId(taskId, userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found for this user");
        }
        return taskRepository.findStepsByTaskId(taskId, isCompleted);
    }

    public User createUser(String userName) throws Exception {
        return userRepository.save(userName);
    }
}
