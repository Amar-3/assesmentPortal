package com.portal.dao;

import com.portal.model.Question;
import com.portal.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    public void createQuestion(Question question) throws SQLException {
        String query = "INSERT INTO questions (test_id, question, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, question.getTestId());
            stmt.setString(2, question.getQuestion());
            stmt.setString(3, question.getOptions()[0]);
            stmt.setString(4, question.getOptions()[1]);
            stmt.setString(5, question.getOptions()[2]);
            stmt.setString(6, question.getOptions()[3]);
            stmt.setInt(7, question.getCorrectOption());
            stmt.executeUpdate();
        }
    }


    public List<Question> getQuestionsByTestId(int testId) throws SQLException {
    List<Question> questions = new ArrayList<>();
    String query = "SELECT * FROM questions WHERE testId = ?";
    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, testId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Question question = new Question();
            question.setQuestionId(resultSet.getInt("questionId"));
            question.setTestId(resultSet.getInt("testId"));
            question.setQuestion(resultSet.getString("question"));
            question.setOptions(new String[]{
                    resultSet.getString("option1"),
                    resultSet.getString("option2"),
                    resultSet.getString("option3"),
                    resultSet.getString("option4")
            });
            question.setCorrectOption(resultSet.getInt("correctOption"));
            questions.add(question);
        }
    }
    return questions;
}

}
