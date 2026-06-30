package com.gestion.utilisateurs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:h2:./data/gestion_utilisateurs;MODE=MySQL;DATABASE_TO_UPPER=false;AUTO_SERVER=TRUE";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    static {
        try {
            initializeDatabase();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private static void initializeDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "first_name VARCHAR(100) NOT NULL, " +
                    "last_name VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(150) NOT NULL, " +
                    "password VARCHAR(150) NOT NULL" +
                    ")");
            statement.execute("ALTER TABLE users ADD COLUMN IF NOT EXISTS password VARCHAR(150) NOT NULL DEFAULT ''");
        }
    }
}
