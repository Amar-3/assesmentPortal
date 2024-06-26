package com.portal.servlet;

import com.portal.dao.QuestionDAO;
import com.portal.dao.ResultDAO;
import com.portal.model.Question;
import com.portal.model.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user/submitTest")
public class SubmitTestServlet extends HttpServlet {
    private QuestionDAO questionDAO = new QuestionDAO();
    private ResultDAO resultDAO = new ResultDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        int testId = Integer.parseInt(request.getParameter("testId"));

        try {
            List<Question> questions = questionDAO.getQuestionsByTestId(testId);
            int score = 0;

            for (Question question : questions) {
                String userAnswer = request.getParameter("question" + question.getQuestionId());
                if (userAnswer != null && Integer.parseInt(userAnswer) == question.getCorrectOption()) {
                    score++;
                }
            }

            // Save the result
            Result result = new Result();
            result.setUserId(userId);
            result.setTestId(testId);
            result.setScore(score);

            resultDAO.saveResult(result);

            // Set attributes and forward to the result page
            request.setAttribute("score", score);
            request.setAttribute("total", questions.size());
            request.getRequestDispatcher("/user/testResult.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
