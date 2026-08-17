package org.stepbystep.stepbystep.repository;

import org.springframework.stereotype.Repository;
import org.stepbystep.stepbystep.db.DatabaseConnection;
import org.stepbystep.stepbystep.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private User map(ResultSet rs) throws SQLException {
        return new User(
          rs.getString("id"),
          rs.getString("user_name"),
          List.of()
        );
    }

    public List<User> findAll() throws SQLException, IOException {
        List<User> users = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement selectAllUsers = connection.prepareStatement("SELECT * FROM users;");
            ResultSet resultSet = selectAllUsers.executeQuery()
        ) {
            while(resultSet.next()) {
                users.add(map(resultSet));
            }
        }
        return users;
    }
}