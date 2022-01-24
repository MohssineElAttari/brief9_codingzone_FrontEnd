package servletController;

import dao.DAO;
import factory.DaoFactory;
import models.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindQuestionServlet", value = "/FindQuestionServlet")
public class FindQuestionServlet extends HttpServlet {
    private DAO<Question> daoQuestion= DaoFactory.getQuestionImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Question> listQuestion =( List<Question>) daoQuestion.findAll();
        request.setAttribute("listQuestion",listQuestion);

        request.getRequestDispatcher("/stuff/question.jsp").forward(request,response);

    }
}
