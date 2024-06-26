package com.portal.servlet;

import com.portal.dao.TestDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/deleteTest")
public class DeleteTestServlet extends HttpServlet {
    private TestDAO testDAO = new TestDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int testId = Integer.parseInt(request.getParameter("testId"));

        try {
            testDAO.deleteTest(testId);
            response.sendRedirect("dashboard");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
