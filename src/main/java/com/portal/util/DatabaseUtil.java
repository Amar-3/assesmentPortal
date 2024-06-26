package com.portal.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // at first storing the values into a variables of appropriate datatype. 
    // that is remote enviroment connection is stored here in this code file.
    private static final String URL = "jdbc:mysql://localhost:3306/studentassessmentportal";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Amar123@$";

    // this one is a method that will make the connection estabished.

    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Get a connection to the database
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Database error", e);
        }
    }

    // connection established.

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



