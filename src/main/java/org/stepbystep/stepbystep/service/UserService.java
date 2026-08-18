package org.stepbystep.stepbystep.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
}
