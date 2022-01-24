package daoImpl;

import dao.DAO;
import models.Question;
import models.Staff;
import models.TestStudent;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionDaoImpl extends DAO<Question> {




    @Override
    public int create(Question question)  {
        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement("INSERT INTO question ( content,reponse1,reponse2,reponse3,reponse4,duration,score,trueanswer) VALUES (?,?,?,?,?,?,?,?);");

            preparedStatement.setString(1, question.getContent());
            preparedStatement.setString(2,question.getReponse1());
            preparedStatement.setString(3,question.getReponse2());
            preparedStatement.setString(4,question.getReponse3());
            preparedStatement.setString(5,question.getReponse4());
            preparedStatement.setInt(6, question.getDuration());
            preparedStatement.setInt(7, question.getScore());
            preparedStatement.setInt(8, question.getTrueAnswer());







            int resultSet = preparedStatement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return 0;
        }




    }

    @Override
    public List<Question> findAll() {

        try {
            String query = "select * from question";

            PreparedStatement preparedStatement =this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Question> listQuestion = new ArrayList<Question>();
            while (resultSet.next()) {
                //System.out.print( resultSet.getString("content"));
                listQuestion.add(new Question(
                        resultSet.getInt("id_question"),
                        resultSet.getString("content"),

                        resultSet.getString("reponse1"),
                        resultSet.getString("reponse2"),
                        resultSet.getString("reponse3"),
                        resultSet.getString("reponse4"),
                        resultSet.getInt("trueanswer"),
                        resultSet.getInt("duration"),
                        resultSet.getInt("score")));
            }
            System.out.print(listQuestion);
            return listQuestion;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public List<Question> findByTest(int id_test) {

        try {
            String query = "select * from question where id_question in (select id_question from id_test=?)";

            PreparedStatement preparedStatement =this.connection.prepareStatement("select * from question where id_question in (select id_question from test_question where  id_test=?)");
            preparedStatement.setInt(1,id_test);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Question> listQuestion = new ArrayList<Question>();
            while (resultSet.next()) {
                listQuestion.add(new Question(
                        resultSet.getInt("id_question"),
                        resultSet.getString("content"),

                        resultSet.getString("reponse1"),
                        resultSet.getString("reponse2"),
                        resultSet.getString("reponse3"),
                        resultSet.getString("reponse4"),
                        resultSet.getInt("trueanswer"),
                        resultSet.getInt("duration"),
                        resultSet.getInt("score")));
            }
            System.out.print(listQuestion);
            return listQuestion;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Question find(int id) {
        Question question = null;
        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement("SELECT * FROM question  WHERE id_question =?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                 question = new Question();
                question.setId_question(resultSet.getInt("id_question"));
                question.setContent(resultSet.getString("content"));
                question.setReponse1(resultSet.getString("reponse1"));
                question.setReponse2(resultSet.getString("reponse2"));
                question.setReponse3(resultSet.getString("reponse3"));
                question.setReponse4(resultSet.getString("reponse4"));
                question.setDuration(resultSet.getInt("duration"));
                question.setScore(resultSet.getInt("score"));
                question.setTrueAnswer(resultSet.getInt("trueanswer"));





            }

            return question;
        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return null;
        }
    }

    public int getStudentAnswer(TestStudent testStudent,int idQuestion){
     int r=-1;
        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement("SELECT answer FROM \"testStudentAnswer\"  WHERE id_question =? and id_teststudent=?");
            preparedStatement.setInt(1, idQuestion);
            preparedStatement.setInt(2, testStudent.getIdTestStudent());


            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

r=resultSet.getInt("answer");




            }

            return r;
        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
     return r;
    }
    @Override
    public int update(Question question) {
        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement("UPDATE  question set content=?,reponse1=?,reponse2=?,reponse3=?,reponse4=?,duration=?,score=?,trueanswer=? where id_question=?;");
            preparedStatement.setString(1, question.getContent());
            preparedStatement.setString(2,question.getReponse1());
            preparedStatement.setString(3,question.getReponse2());
            preparedStatement.setString(4,question.getReponse3());
            preparedStatement.setString(5,question.getReponse4());
            preparedStatement.setInt(6, question.getDuration());
            preparedStatement.setInt(7, question.getScore());
            preparedStatement.setInt(8, question.getTrueAnswer());
            preparedStatement.setInt(9, question.getId_question());



            int resultSet = preparedStatement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return 0;
        }



    }

    @Override
    public int delete(int id) {

        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement("DELETE from question where id_question=?");
            preparedStatement.setInt(1, id);


            int flag = preparedStatement.executeUpdate();

            return flag;
        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return 0;
        }

    }


    @Override
    public Question login(Question obj) {
        return null;
    }
}
