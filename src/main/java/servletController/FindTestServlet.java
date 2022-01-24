package servletController;

import dao.DAO;
import factory.DaoFactory;
import models.Question;
import models.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindTestServlet", value = "/FindTestServlet")
public class FindTestServlet extends HttpServlet {
    private DAO<Test> daoTest= DaoFactory.getTestImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Test> listTest =( List<Test>) daoTest.findAll();
        request.setAttribute("listTest",listTest);

        request.getRequestDispatcher("/stuff/test.jsp").forward(request,response);



    }


}
