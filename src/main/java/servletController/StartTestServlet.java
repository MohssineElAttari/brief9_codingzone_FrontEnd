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

@WebServlet(name = "StartTestServlet", value = "/StartTestServlet")
public class StartTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("studentses")!=null){


        TestStudent testStudentsession= (TestStudent)session.getAttribute("studentses") ;
        String code= testStudentsession.getCode() ;


        DAO<TestStudent> ts = DaoFactory.getTestStudentImpl();

        TestStudent testStudent = ((TestStudentDaoImpl) ts).findByCode(code);
        Test t= DaoFactory.getTestImpl().find(testStudent.getIdTest());
        Student s=DaoFactory.getStudentImpl().find(testStudent.getIdStudent());

        request.setAttribute("test",t);
        request.setAttribute("student",s);
        request.setAttribute("testStudent",testStudent);
        // redirect to test
        request.getRequestDispatcher("/Student/StartTest.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/Student/Code.jsp").forward(request, response);

        }
    }

}
