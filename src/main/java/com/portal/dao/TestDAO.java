package com.portal.dao;

import com.portal.model.Test;
import com.portal.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    public List<Test> getAllTests() throws SQLException {
        String query = "SELECT * FROM tests";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             
        		ResultSet rs = stmt.executeQuery()) {
        	
	            List<Test> tests = new ArrayList<>();
	            while (rs.next()) {
	                Test test = new Test();
	                test.setTestId(rs.getInt("testId"));
	                test.setTag(rs.getString("tag"));
	                test.setNumberOfQuestions(rs.getInt("numberOfQuestions"));
	                tests.add(test);
            }
            return tests;
        }
    }

    public void createTest(Test test) throws SQLException {
        String query = "INSERT INTO tests (tag,numberOfQuestions) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, test.getTag());
            stmt.setInt(2, test.getNumberOfQuestions());
            stmt.executeUpdate();
        }
    }

    public void deleteTest(int testId) throws SQLException {
        String query = "DELETE FROM tests WHERE testId = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, testId);
            stmt.executeUpdate();
        }
    }

    // Add this method to TestDAO.java
    public void updateTest(Test test) throws SQLException {
        String query = "UPDATE tests SET tag = ?, numberOfQuestions = ? WHERE testId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, test.getTag());
            statement.setInt(2, test.getNumberOfQuestions());
            statement.setInt(3, test.getTestId());
            statement.executeUpdate();
    }
}
	// getconnection we witnessed getConnection method is undefined for this code module.
	// since this method was declared inthat file so whn i have to use it i got to use it like the OOP. was the method 
	public Test getTestById(int testId) throws SQLException {
	    String query = "SELECT * FROM tests WHERE testId = ?";
	    try (Connection connection = DatabaseUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, testId);
	        ResultSet resultSet = statement.executeQuery();
	
	        if (resultSet.next()) {
	            Test test = new Test();
	            test.setTestId(resultSet.getInt("testId"));
	            test.setTag(resultSet.getString("tag"));
	            test.setNumberOfQuestions(resultSet.getInt("numberOfQuestions"));
	            return test;
	        }
	    }
	    return null;
	}

}
