package org.stepbystep.stepbystep.db;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class DatabaseConnection {
    public static Connection getConnection() throws Exception {
        List<String> lines = Files.readAllLines(Path.of(".env"));
        String url = "", user = "", password = "";
        for (String line : lines) {
            if (line.startsWith("DB_URL=")) url = line.substring(7);
            if (line.startsWith("DB_USER=")) user = line.substring(8);
            if (line.startsWith("DB_PASSWORD=")) password = line.substring(12);
        }
        return DriverManager.getConnection(url, user, password);
    }
}