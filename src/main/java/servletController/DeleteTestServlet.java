package servletController;

import dao.DAO;
import factory.DaoFactory;
import models.Question;
import models.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTestServlet", value = "/DeleteTestServlet")
public class DeleteTestServlet extends HttpServlet {

    private DAO<Test> daoTest= DaoFactory.getTestImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTest= Integer.parseInt( request.getParameter( "id"));

        int flag = daoTest.delete(idTest);
        response.sendRedirect("FindTestServlet");
    }


}
