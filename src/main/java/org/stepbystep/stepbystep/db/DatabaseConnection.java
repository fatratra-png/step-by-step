package org.stepbystep.stepbystep.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException, IOException {
        String[] lines = Files.readAllLines(Path.of(".env")).toArray(new String[0]);
        String url = lines[0].split("=", 2)[1];
        String password = lines[1].split("=", 2)[1];
        String user = lines[2].split("=", 2)[1];
        return DriverManager.getConnection(url, user, password);
    }
}