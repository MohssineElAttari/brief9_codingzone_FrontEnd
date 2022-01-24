package servletController;

import config.Config;
import dao.DAO;
import daoImpl.TestDaoImpl;
import factory.DaoFactory;
import models.Staff;
import models.Test;
import models.TestQuestion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "AddTestServlet", value = "/AddTestServlet")
public class AddTestServlet extends HttpServlet {
    private DAO<Test> daoTest= DaoFactory.getTestImpl();
    private DAO<TestQuestion> daoTestQst= DaoFactory.getTestQstsImpl();


    private Connection connection = Config.getInstance();



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String name = request.getParameter("Nomtest");
        String description=  request.getParameter( "description");

        if(session.getAttribute("staff")!=null) {
            int id_Staff = ((Staff) session.getAttribute("staff")).getId();

            Test test = new Test(name, description, id_Staff);
            Test flag = ((TestDaoImpl)daoTest).create(test,0);

            String[] questions=request.getParameterValues("questions");

        for(int i=0;i<questions.length;i++) {
            int id_question = Integer.parseInt(questions[i]);
            TestQuestion testQts = new TestQuestion(flag.getId_test(), id_question);
            int flag_q = daoTestQst.create(testQts);
        }

        }
        else{
            System.out.println("no Staff");
        }

        response.sendRedirect("FindTestServlet");


    }
}
