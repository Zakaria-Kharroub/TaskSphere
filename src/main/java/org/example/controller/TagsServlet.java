package org.example.controller;

import org.example.domaine.Tag;
import org.example.service.TagService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TagsServlet", urlPatterns = {"/tags"})
public class TagsServlet extends HttpServlet {

    private TagService tagService;

    public void init() throws ServletException{
        tagService = new TagService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tag> tags = tagService.getAlltags();
        request.setAttribute("tags",tags);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tags.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected  void doPost(HttpServletRequest req ,HttpServletResponse resp) throws ServletException ,IOException{
        String action = req.getParameter("action");
        if ("delete".equals(action)){
            delete(req,resp);
        } else if ("update".equals(action)){
            throw new UnsupportedOperationException("Not implemented yet");
        } else {
            save(req,resp);
        }
    }


    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String name = req.getParameter("name");

        if (name ==null){
            resp.getWriter().write("name required");
        }

        Tag tag = new Tag();
        tag.setName(name);

        tagService.saveTag(tag);
        resp.sendRedirect("tags");

    }

    private void delete(HttpServletRequest req , HttpServletResponse resp) throws IOException{
        Long id = Long.parseLong(req.getParameter("id"));
        tagService.deletetag(id);
        resp.sendRedirect("tags");
    }




}