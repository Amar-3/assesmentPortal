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
import java.util.List;

@WebServlet("/admin/dashboard")
public  class AdminDashboardServlet extends HttpServlet {
    
	private TestDAO testDAO = new TestDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside doGet method of AdminDashboardServlet"); // Add debug statement
        try {
            List<Test> tests = testDAO.getAllTests();
            System.out.println("Number of tests fetched: " + tests.size()); // Add debug statement
            request.setAttribute("tests", tests);
            System.out.println("Number of tests fetched: after setattiributes " + tests.size());
            System.out.println("Number of tests fetched: " + tests.size());
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            System.out.println("Number of tests fetched: after redirection " + tests.size());
        } catch (SQLException e) {
            throw new ServletException("Error fetching tests", e);
        }
    }
}
