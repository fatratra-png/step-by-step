package org.stepbystep.stepbystep.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.stepbystep.stepbystep.model.User;
import org.stepbystep.stepbystep.repository.UserRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }
}
