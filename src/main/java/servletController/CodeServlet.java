package servletController;

import dao.DAO;
import daoImpl.TestStudentDaoImpl;
import factory.DaoFactory;
import models.Student;
import models.Test;
import models.TestStudent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CodeServlet", value = "/CodeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("code") != null) {
            String code = request.getParameter("code");

            DAO<TestStudent> ts = DaoFactory.getTestStudentImpl();

            TestStudent testStudent = ((TestStudentDaoImpl) ts).findByCode(code);
            if (testStudent != null) {
                HttpSession session = request.getSession();
                session.setAttribute("studentses", testStudent);

                request.getRequestDispatcher("/HomeServlet").forward(request, response);

            } else {
//                request.setAttribute("error", "Code invalide");
                request.getRequestDispatcher("/Student/invalid.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/Student/Code.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("code");

        DAO<TestStudent> ts = DaoFactory.getTestStudentImpl();

        TestStudent testStudent = ((TestStudentDaoImpl) ts).findByCode(code);

        if(testStudent!=null){
            HttpSession session = request.getSession();
            session.setAttribute("studentses", testStudent);

            request.getRequestDispatcher("/HomeServlet").forward(request, response);


        }
        else{
            request.setAttribute("error","Code invalide");
            request.getRequestDispatcher("/Student/Code.jsp").forward(request,response);

        }
    }
}
