package org.example.controller;

import org.example.domaine.User;
import org.example.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/users"})
public class UserServlet extends HttpServlet {

    private UserRepository userRepository;

    public void init() throws ServletException {
        userRepository = new UserRepository();
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/test.jsp");
//        requestDispatcher.forward(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> users = userRepository.getAll();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/test.jsp");
        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        save(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (name == null || email == null) {
            resp.getWriter().write("Missing user information");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userRepository.save(user);
//       reidrect to /users
        resp.sendRedirect("users");



    }
}