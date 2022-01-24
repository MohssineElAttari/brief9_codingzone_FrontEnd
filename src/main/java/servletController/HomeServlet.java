package servletController;

import daoImpl.TestStudentDaoImpl;
import models.TestStudent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("studentses")!=null){

            TestStudent testStudent= (TestStudent)session.getAttribute("studentses") ;
            String code= testStudent.getCode() ;
            int[] testStudentInfo=new TestStudentDaoImpl().infotest(code);


            request.setAttribute("testStudentInfo",testStudentInfo );
            request.getRequestDispatcher("/Student/Home.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/Student/Code.jsp").forward(request, response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("studentses")!=null){

            TestStudent testStudent= (TestStudent)session.getAttribute("studentses") ;
            String code= testStudent.getCode() ;
            int[] testStudentInfo=new TestStudentDaoImpl().infotest(code);


            request.setAttribute("testStudentInfo",testStudentInfo );
            request.getRequestDispatcher("/Student/Home.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/Student/Code.jsp").forward(request, response);

        }


    }



}
