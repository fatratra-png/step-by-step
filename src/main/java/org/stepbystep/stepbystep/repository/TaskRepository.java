package org.stepbystep.stepbystep.repository;

import org.springframework.stereotype.Repository;
import org.stepbystep.stepbystep.db.DatabaseConnection;
import org.stepbystep.stepbystep.model.Step;
import org.stepbystep.stepbystep.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private Step mapStep(ResultSet rs) throws SQLException {
        return new Step(
          rs.getString("id"),
          rs.getString("title"),
          rs.getString("description"),
          rs.getBoolean("is_completed")
        );
    }

    public List<Task> findByUserId(int userId) throws Exception {
        List<Task> tasks = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement selectTasks = connection.prepareStatement("SELECT * FROM tasks WHERE user_id = ?;")
        ) {
            selectTasks.setInt(1, userId);
            try(ResultSet resultSet = selectTasks.executeQuery()) {
                while(resultSet.next()) {
                    tasks.add(new Task(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        findStepsByTaskId(resultSet.getInt("id"))
                    ));
                }
            }
        }
        return tasks;
    }

    private List<Step> findStepsByTaskId(int taskId) throws Exception {
        List<Step> steps = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement selectSteps = connection.prepareStatement("SELECT * FROM steps WHERE task_id = ?;")
        ) {
            selectSteps.setInt(1, taskId);
            try(ResultSet resultSet = selectSteps.executeQuery()) {
                while(resultSet.next()) {
                    steps.add(mapStep(resultSet));
                }
            }
        }
        return steps;
    }
}
