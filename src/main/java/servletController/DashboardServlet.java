package servletController;

import daoImpl.TestDaoImpl;
import daoImpl.TestStudentDaoImpl;
import factory.DaoFactory;
import models.TestsByDates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "DashboardServlet", value = "/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dashboard(request,response);
        request.getRequestDispatcher("/stuff/dashboard.jsp").forward(request,response);

    }

    private void dashboard(HttpServletRequest request, HttpServletResponse response) {

        List<TestsByDates> testByDates= ((TestStudentDaoImpl)DaoFactory.getTestStudentImpl()).getTestsByDates();
        int AffectedTests =((TestStudentDaoImpl)DaoFactory.getTestStudentImpl()).AffectedTests();
        int PassedTests =((TestStudentDaoImpl)DaoFactory.getTestStudentImpl()).PassedTests();
        int NonPassedTests =((TestStudentDaoImpl)DaoFactory.getTestStudentImpl()).NonPassedTests();
        int ScoresTests =((TestStudentDaoImpl)DaoFactory.getTestStudentImpl()).ScoresTests(75); // 75%

        request.setAttribute("testByDates",testByDates);
        request.setAttribute("affectedTests",AffectedTests);
        request.setAttribute("passedTests",PassedTests);
        request.setAttribute("nonPassedTests",NonPassedTests);
        request.setAttribute("scoresTests",ScoresTests);
        // "L1","L2","L3"
        request.setAttribute("labels",testByDates.stream().map(td->"\""+td.getDate().toString()+"\"").collect(Collectors.joining(",")));
        // 1,2,3
        request.setAttribute("data",testByDates.stream().map(td->String.valueOf(td.getTests())).collect(Collectors.joining(",")));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dashboard(request,response);
        request.getRequestDispatcher("/stuff/dashboard.jsp").forward(request,response);


    }
}
