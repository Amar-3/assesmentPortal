package com.portal.servlet;

import com.portal.dao.QuestionDAO;
import com.portal.dao.TestDAO;
import com.portal.model.Question;
import com.portal.model.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user/takeTest")
public class TakeTestServlet extends HttpServlet {
    private TestDAO testDAO = new TestDAO();
    private QuestionDAO questionDAO = new QuestionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int testId = Integer.parseInt(request.getParameter("testId"));

        try {
            Test test = testDAO.getTestById(testId);
            List<Question> questions = questionDAO.getQuestionsByTestId(testId);

            request.setAttribute("test", test);
            request.setAttribute("questions", questions);

            request.getRequestDispatcher("/user/takeTest.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
