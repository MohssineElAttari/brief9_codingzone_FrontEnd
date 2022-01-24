package servletController;

import daoImpl.TestStudentDaoImpl;
import factory.DaoFactory;
import helpers.MailJava;
import models.*;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ScoreServlet", value = "/ScoreServlet")
public class ScoreServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();


        int idTestStudent=Integer.parseInt(request.getParameter("testStudent"));
        TestStudent testStudent=DaoFactory.getTestStudentImpl().find(idTestStudent);
        String code = testStudent.getCode();
        int idTest=Integer.parseInt(request.getParameter("test"));
        int idStudent=Integer.parseInt(request.getParameter("student"));
        double Score=0,TotalScore=0;
        Student student = DaoFactory.getStudentImpl().find(idStudent);
        String email =student.getEmail();
        if(testStudent!=null) {

            if (testStudent.getIdStudent() == idStudent && testStudent.getIdTest() == idTest && testStudent.getDateTest() == null) {
                Test test = DaoFactory.getTestImpl().find(idTest);
                for (Question q : test.getQuestions()) {
                    TestStudentAnswer tsa = new TestStudentAnswer();
                    tsa.setId_question(q.getId_question());
                    tsa.setId_test(idTest);
                    tsa.setId_student(idStudent);

                    int answer = -1;
                    if (request.getParameter(String.valueOf(q.getId_question())) != null) {
                        answer = Integer.parseInt(request.getParameter(String.valueOf(q.getId_question())));

                    }
                    tsa.setAnswer(answer);
                    tsa.setId_teststudent(testStudent.getIdTestStudent());
                    DaoFactory.getTestStudentAnswerImpl().create(tsa);
                    Score += (answer == q.getTrueAnswer()) ? q.getScore() : 0;
                    TotalScore += q.getScore();


                }

                testStudent.setDateTest(new Date(new java.util.Date().getTime()));
                testStudent.setScore((int) Score);
                testStudent.setFullScore((int) TotalScore);

                DaoFactory.getTestStudentImpl().update(testStudent);


            }
            String subject= "Rapport Test Youcode";
            String textObject = "<div style='display:flex;flex-direction:column;width:35vw;margin:auto;border:1px solid #000;'>\n" +
                    "    <div\n" +
                    "        style='text-align: center;width:300px;background-color:aliceblue;padding:40px;'>\n" +
                    "        <img style='width: 200px;height: 50px;'\n" +
                    "            src='https://simplon.co/storage/36009/responsive-images/logo-youcode-ma___medialibrary_original_685_136.png'>\n" +
                    "        <h2>Rapport ets disponible</h2>\n" +
                    "    </div>\n" +
                    "    <div style='padding:20px'>\n" +
                    "        <p><span style='font-weight:bold'>Bonjour</span> Cher apprenant </p>\n" +
                    "        <p>Bonne nouvelle ! Votre rapport de test est disponible.</p><a href='http://localhost:8080/codingZone_war_exploded/RapportServlet?code="+code+"'"+
                    "            style='background-color:#03a9f4;color:#ffffff;font-family:Arial,Helvetica,sans-serif;font-size:14px;font-weight:bold;line-height:42px;text-align:center;text-decoration:none;width:200px;margin:auto;border:none;padding:1opx;display:block'\n" +
                    "            type='submit' target='_blank'>VOIR\n" +
                    "            MON RAPPORT</a>\n" +
                    "        <p>L'équipe CofingZone</p>\n" +
                    "    </div>\n" +
                    "</div>";
//

            try {
                MailJava.SendMail(email, subject,textObject);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            request.setAttribute("score", Score);
            request.setAttribute("totalScore", TotalScore);
        }
        else{
            System.out.println("NO ST");
        }

        request.getRequestDispatcher("/Student/Score.jsp").forward(request,response);

    }
}
