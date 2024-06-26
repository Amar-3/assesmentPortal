package com.portal.servlet;

import com.portal.dao.QuestionDAO;
import com.portal.model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/createQuestion")
public class CreateQuestionServlet extends HttpServlet {
    private QuestionDAO questionDAO = new QuestionDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int testId = Integer.parseInt(request.getParameter("testId"));
        String questionText = request.getParameter("question");
        String[] options = {
                request.getParameter("option1"),
                request.getParameter("option2"),
                request.getParameter("option3"),
                request.getParameter("option4")
        };
        int correctOption = Integer.parseInt(request.getParameter("correctOption"));

        Question question = new Question();
        question.setTestId(testId);
        question.setQuestion(questionText);
        question.setOptions(options);
        question.setCorrectOption(correctOption);

        try {
            questionDAO.createQuestion(question);
            response.sendRedirect("dashboard");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
