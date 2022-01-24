package servletController;

import dao.DAO;
import daoImpl.StudentDaoImpl;
import daoImpl.TestDaoImpl;
import daoImpl.TestStudentDaoImpl;
import factory.DaoFactory;
import helpers.MailJava;
import models.*;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RapportServlet", value = "/RapportServlet")
public class RapportServlet extends HttpServlet {
    private TestDaoImpl daoTest = (TestDaoImpl) DaoFactory.getTestImpl();
    private StudentDaoImpl daoStudent = (StudentDaoImpl) DaoFactory.getStudentImpl();
    private TestStudentDaoImpl testStudentDao = (TestStudentDaoImpl) DaoFactory.getTestStudentImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("code") != null) {
            String code = request.getParameter("code");

            TestStudent testStudent = testStudentDao.findByCodeRapport(code);

            if (testStudent != null) {
                int idTest = testStudent.getIdTest();
                int idStudent = testStudent.getIdStudent();
                Student student = DaoFactory.getStudentImpl().find(idStudent);

                HttpSession session = request.getSession();
                session.setAttribute("studentses", testStudent);
                Test test = DaoFactory.getTestImpl().find(idTest);

                double Score=testStudent.getScore(),TotalScore=testStudent.getFullScore();
                request.setAttribute("testStudent",testStudent);
                request.setAttribute("student",student);
                request.setAttribute("test",test);
                request.getRequestDispatcher("/Student/Rapport.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Code invalide");
                request.getRequestDispatcher("/Student/invalid.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/Student/invalid.jsp").forward(request, response);
        }
    }
}
