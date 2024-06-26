package com.portal.servlet;

import com.portal.dao.UserDAO;
import com.portal.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String mobileNumber = request.getParameter("mobileNumber");
        String password = request.getParameter("password");
        String role = request.getParameter("role");


        User user = new User();
        user.setUsername(username);
        user.setMobileNumber(mobileNumber);
        user.setPassword(password);
        user.setRole(role);

        try {
            userDAO.registerUser(user);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error registering user", e);
        }
    }
}
