package daoImpl;

import dao.DAO;
import models.TestStudent;
import models.TestStudentAnswer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestStudentAnswerDaoImpl extends DAO<TestStudentAnswer> {


    @Override
    public int create(TestStudentAnswer obj) {

        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement("INSERT INTO \"testStudentAnswer\" (id,id_student,id_test,id_question,answer,id_teststudent) VALUES (DEFAULT,?,?,?,?,?);");
            preparedStatement.setInt(1,obj.getId_student());
            preparedStatement.setInt(2,obj.getId_test());
            preparedStatement.setInt(3,obj.getId_question());
            preparedStatement.setInt(4,obj.getAnswer());
            preparedStatement.setInt(5,obj.getId_teststudent());


            int resultSet = preparedStatement.executeUpdate();

            return  resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<TestStudentAnswer> findAll() {
        try {
            String query = "select * from testStudentAnswer";

            PreparedStatement preparedStatement =this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<TestStudentAnswer> tsi= new ArrayList<TestStudentAnswer>();
            while (resultSet.next()) {
                tsi.add(new TestStudentAnswer(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_teststudent"),
                        resultSet.getInt("id_student"),
                        resultSet.getInt("id_test"),
                        resultSet.getInt("id_question"),
                        resultSet.getInt("answer")));

            }
            return tsi;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TestStudentAnswer find(int id) {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM testStudentAnswer where id=? ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            TestStudentAnswer tsa = null;
            while (resultSet.next()) {

                tsa = new TestStudentAnswer();
                tsa.setId(resultSet.getInt("id"));
                tsa.setId_teststudent(resultSet.getInt("id_teststudent"));
                tsa.setId_student(resultSet.getInt("id_student"));
                tsa.setId_test(resultSet.getInt("id_test"));
                tsa.setId_question(resultSet.getInt("id_question"));
                return tsa;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int update(TestStudentAnswer obj) {return 0;}

    @Override
    public int delete(int id) {return 0;}

    @Override
    public TestStudentAnswer login(TestStudentAnswer obj) {return null;}
}
