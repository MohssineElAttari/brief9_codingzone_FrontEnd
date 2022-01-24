package servletController;

import daoImpl.StudentDaoImpl;
import daoImpl.TestDaoImpl;
import daoImpl.TestStudentDaoImpl;
import factory.DaoFactory;
import helpers.MailJava;
import models.Test;
import models.TestStudent;
import models.TestStudentSended;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "AffecterTestServlet", value = "/AffecterTestServlet")
public class AffecterTestServlet extends HttpServlet {

    private TestDaoImpl daoTest = (TestDaoImpl) DaoFactory.getTestImpl();
    private StudentDaoImpl daoStudent = (StudentDaoImpl) DaoFactory.getStudentImpl();
    private TestStudentDaoImpl testStudentDao = (TestStudentDaoImpl) DaoFactory.getTestStudentImpl();

    public void loadData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Test> listTest = daoTest.findAll();
        request.setAttribute("listTest", listTest);
        request.getRequestDispatcher("/stuff/affecterTest.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       loadData(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<TestStudentSended> operationResponse=new ArrayList<TestStudentSended>() ;


      DateFormat date=new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
        Date datelimite= null;
        try {
            datelimite =  new Date(date.parse(request.getParameter("date_limite")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int idtest = Integer.parseInt(request.getParameter("id_test"));
        String[] studentOBJ= request.getParameterValues( "studentOBJ");

        for(String std : studentOBJ) {
            String[] parts = std.split("-");
            String id_std = parts[0];
            int id_stdint =Integer.parseInt(id_std);
            String email = parts[1];


            // It will generate 6 digit random Number.
            // from 0 to 999999
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            // this will convert any number sequence into 6 character.
            String code = String.format("%06d", number);

            //Set Subject header field
            String subject = "Convocation Test Youcode";

            //Now set the actual message
            String message= "Bonjour , vous etes convoquer à passer le test afin de pouvoir nous rejoindre à Youcode , merci d'entrer le code suivant afin d'acceder à l'application ,Votre Code est :"+code+"" +
                    "<a href='http://localhost:8080/codingZone_war_exploded/CodeServlet?code="+code+"'>Click ici pour demarrer </a>";

            try {
                if(MailJava.SendMail(email, subject,message)){
                    // enregistrement test_student :

                    TestStudent obj =new TestStudent(idtest, id_stdint,datelimite ,code);

            int flag =testStudentDao.create(obj);
                    operationResponse.add(new TestStudentSended(idtest,email,true));
                }
                else{

                    operationResponse.add(new TestStudentSended(idtest,email,false));
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("operationsResponse",operationResponse);

        loadData(request,response);

    }

}

