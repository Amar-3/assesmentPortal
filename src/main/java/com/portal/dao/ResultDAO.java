package com.portal.dao;

import com.portal.model.Result;
import com.portal.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {
    public List<Result> getResultsByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM results WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            List<Result> results = new ArrayList<>();
            while (rs.next()) {
                Result result = new Result();
                result.setResultId(rs.getInt("result_id"));
                result.setUserId(rs.getInt("user_id"));
                result.setTestId(rs.getInt("test_id"));
                result.setScore(rs.getInt("score"));
                result.setDate(rs.getDate("date"));
                results.add(result);
            }
            return results;
        }
    }

    public void createResult(Result result) throws SQLException {
        String query = "INSERT INTO results (user_id, test_id, score, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, result.getUserId());
            stmt.setInt(2, result.getTestId());
            stmt.setInt(3, result.getScore());
            stmt.setDate(4, result.getDate());
            stmt.executeUpdate();
        }
    }

    // Add this method to ResultDAO.java
public void saveResult(Result result) throws SQLException {
    String query = "INSERT INTO results (userId, testId, score, date) VALUES (?, ?, ?, NOW())";
    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, result.getUserId());
        statement.setInt(2, result.getTestId());
        statement.setInt(3, result.getScore());
        statement.executeUpdate();
    }
}

}
