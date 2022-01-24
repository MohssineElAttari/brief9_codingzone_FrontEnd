package daoImpl;

import dao.DAO;
import models.Question;
import models.TestStudent;
import models.TestsByDates;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestStudentDaoImpl extends DAO<TestStudent> {

    @Override
    public int create(TestStudent obj) {
        try {
            String query = "INSERT INTO test_student(id_test, id_student, date , code, date_limite) VALUES (?, ?,?,?,? )";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, obj.getIdTest());
            preparedStatement.setInt(2, obj.getIdStudent());
            preparedStatement.setDate(3, obj.getDateTest());
            preparedStatement.setString(4, obj.getCode());
            preparedStatement.setDate(5, obj.getDatelimite());



            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<TestStudent> findAll() {
        try {
            String query = "select * from test_student";

            PreparedStatement preparedStatement =this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<TestStudent> ts = new ArrayList<TestStudent>();
            while (resultSet.next()) {
                ts.add(new TestStudent(
                        resultSet.getInt("id_testStudent"),
                        resultSet.getInt("id_test"),
                        resultSet.getInt("id_student"),
                        resultSet.getDate("date"),
                        resultSet.getString("code"),
                        resultSet.getDate("date_limite"),
                        resultSet.getInt("score"),
                        resultSet.getInt("fullScore")

                        ));


            }
            return ts;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public TestStudent login(TestStudent obj) {
        return null;
    }


    @Override
    public TestStudent find(int id) {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM test_student where \"id_testStudent\"=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            TestStudent ts = null;
            while (resultSet.next()) {

                ts = new TestStudent();
                ts.setIdTestStudent(resultSet.getInt("id_testStudent"));
                ts.setIdStudent(resultSet.getInt("id_student"));
                ts.setIdTest(resultSet.getInt("id_test"));
                ts.setCode(resultSet.getString("code"));
                ts.setDateTest(resultSet.getDate("date"));
                ts.setDatelimite(resultSet.getDate("date_limite"));
                ts.setScore(resultSet.getInt("score"));
                ts.setFullScore(resultSet.getInt("fullScore"));

                return ts;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(TestStudent obj) {
        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement("UPDATE test_student set id_test =?,id_student=?,date =?,code=?,date_limite=?, score=?, \"fullScore\"=? where \"id_testStudent\"=?");
            preparedStatement.setInt(1,obj.getIdTest());
            preparedStatement.setInt(2,obj.getIdStudent());
            preparedStatement.setDate(3,obj.getDateTest());
            preparedStatement.setString(4,obj.getCode());
            preparedStatement.setDate(5,obj.getDatelimite());
            preparedStatement.setInt(8,obj.getIdTestStudent());
            preparedStatement.setInt(6,obj.getScore());
            preparedStatement.setInt(7,obj.getFullScore());




            int resultSet = preparedStatement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int[]  infotest(String code) {

        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("select sum (question.duration) as totalduration ,count (question) as nmbquestion  from test_student ,test_question,question where code=? and test_student.id_test=test_question.id_test and test_question.id_question=question.id_question");
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                int[] result = new int[]{ resultSet.getInt("totalduration"),resultSet.getInt("nmbquestion") };

                return result ;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }






    @Override
    public int delete(int id) {
        return 0;
    }

    public TestStudent findByCode(String code) {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM test_student where code=? and date is null and date_limite> now()");
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            TestStudent ts = null;
            while (resultSet.next()) {

                ts = new TestStudent();
                ts.setIdTestStudent(resultSet.getInt("id_testStudent"));
                ts.setIdStudent(resultSet.getInt("id_student"));
                ts.setIdTest(resultSet.getInt("id_test"));
                ts.setCode(code);
                ts.setDatelimite(resultSet.getDate("date_limite"));
                return ts;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public TestStudent findByCodeRapport(String code) {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM test_student where code=?");
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            TestStudent ts = null;
            while (resultSet.next()) {

                ts = new TestStudent();
                ts.setIdTestStudent(resultSet.getInt("id_testStudent"));
                ts.setIdStudent(resultSet.getInt("id_student"));
                ts.setIdTest(resultSet.getInt("id_test"));
                ts.setCode(code);
                ts.setDateTest(resultSet.getDate("date"));
                ts.setDatelimite(resultSet.getDate("date_limite"));
                ts.setScore(resultSet.getInt("score"));
                ts.setFullScore(resultSet.getInt("fullScore"));
                return ts;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    public int AffectedTests() {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT count(*) as tests FROM test_student");

            ResultSet resultSet = preparedStatement.executeQuery();

            TestStudent ts = null;
            while (resultSet.next()) {

                return resultSet.getInt("tests");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }



    public int PassedTests() {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT count(*) as tests FROM test_student WHERE date is not null ");

            ResultSet resultSet = preparedStatement.executeQuery();

            TestStudent ts = null;
            while (resultSet.next()) {

                return resultSet.getInt("tests");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int NonPassedTests() {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT count(*) as tests FROM test_student WHERE date is null ");

            ResultSet resultSet = preparedStatement.executeQuery();

            TestStudent ts = null;
            while (resultSet.next()) {

                return resultSet.getInt("tests");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int ScoresTests(int limitScore) {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT count(*) as tests FROM test_student WHERE date is not null and (score/\"fullScore\")>=(?/100) ");
            preparedStatement.setInt(1,limitScore);
            ResultSet resultSet = preparedStatement.executeQuery();

            TestStudent ts = null;
            while (resultSet.next()) {

                return resultSet.getInt("tests");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<TestsByDates> getTestsByDates() {
        try {
            String query = "SELECT date,count(*) as tests FROM test_student where date is not null group by date";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<TestsByDates> listTest = new ArrayList<>();
            while (resultSet.next()) {

                listTest.add(new TestsByDates(
                        resultSet.getDate("date"),
                        resultSet.getInt("tests")
                ));
            }

            return listTest;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
