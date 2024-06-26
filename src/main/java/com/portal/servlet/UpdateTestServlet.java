package com.portal.servlet;

import com.portal.dao.TestDAO;
import com.portal.model.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/updateTest")
public class UpdateTestServlet extends HttpServlet {
    private TestDAO testDAO = new TestDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int testId = Integer.parseInt(request.getParameter("testId"));
        String tag = request.getParameter("tag");
        int numberOfQuestions = Integer.parseInt(request.getParameter("numberOfQuestions"));

        Test test = new Test();
        test.setTestId(testId);
        test.setTag(tag);
        test.setNumberOfQuestions(numberOfQuestions);

        try {
            testDAO.updateTest(test);
            response.sendRedirect("dashboard");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
