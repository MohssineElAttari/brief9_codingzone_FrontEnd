package servletController;

import dao.DAO;
import factory.DaoFactory;
import models.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private DAO<Staff> daoStaff= DaoFactory.getStaffImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("staff")==null){
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else{

            request.getRequestDispatcher("DashboardServlet").forward(request,response);

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email= request.getParameter( "email");
        String password=  request.getParameter( "password");


        Staff staff=new Staff(email, password);
        Staff flag= daoStaff.login(staff);

        if (flag != null){
            HttpSession session = request.getSession();
            session.setAttribute("staff", flag);

            request.getRequestDispatcher("DashboardServlet").forward(request,response);
   }
        else{
            String message="email or  password incorrecte";
            request.setAttribute("message",message);

            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }


}
