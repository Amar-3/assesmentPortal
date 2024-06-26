package com.portal.servlet;

import com.portal.dao.UserDAO;
import com.portal.model.User; // importing databse model table==user

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

// for handling authentication step
@WebServlet("/Userlogin")
public class LoginServlet extends HttpServlet {

    // an object is created about a student for login credential and after further redirection
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobileNumber = request.getParameter("mobileNumber");
        String password = request.getParameter("password");

        try {
            //a particular user is created. for the session period of its own
            User user = userDAO.validateUser(mobileNumber, password);

            if (user != null && "user".equals(user.getRole()) ) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getUserId());
                session.setAttribute("role", user.getRole());

                 
                response.sendRedirect(request.getContextPath() + "/user/dashboard");

              
            } else {
                request.setAttribute("errorMessage", "Invalid mobile number or password");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
