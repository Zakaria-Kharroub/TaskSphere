package org.example.controller;

import org.example.domaine.Role;
import org.example.domaine.User;
import org.example.scheduler.TokenScheduler;
import org.example.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "UserServlet", urlPatterns = {"/users"})
public class UserServlet extends HttpServlet {

    private UserService userService;
    private TokenScheduler tokenScheduler;

    public void init() throws ServletException {
        userService = new UserService();
        tokenScheduler = new TokenScheduler();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/test.jsp");
        requestDispatcher.forward(request, response);
//        tokenScheduler.startScheduler();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            delete(req, resp);
        } else if ("update".equals(action)) {
            update(req, resp);
        } else {
            save(req, resp);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String roleParam = req.getParameter("role");
        Role role = Role.valueOf(roleParam);

        if (name == null || email == null || password == null) {
            resp.getWriter().write("name, email and password are required");
            return;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRole(role);
        user.setTokenDelete(1);
        user.setTokenResingne(2);

        userService.saveUser(user);
        resp.sendRedirect("users");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        userService.deleteUser(id);
        resp.sendRedirect("users");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String roleParam = req.getParameter("role");
        Role role = Role.valueOf(roleParam);

        User user = userService.findUserById(id);
        if (user == null) {
            resp.getWriter().write("utilisateur not found");
            return;
        }

        user.setName(name);
        user.setEmail(email);
        user.setRole(role);

        if (password != null && !password.isEmpty()) {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setPassword(hashedPassword);
        }

        userService.updateUser(user);
        resp.sendRedirect("users");
    }
}