package daoImpl;

import dao.DAO;
import factory.DaoFactory;
import models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDaoImpl extends DAO<Test> {

    public Test create(Test test, int xtra) {

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO test ( id_test,name,description,id_staff) VALUES (DEFAULT,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, test.getName());
            preparedStatement.setString(2, test.getDescription());
            preparedStatement.setLong(3, test.getId_staff());

            int resultSet = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                test.setId_test(rs.getInt(1));
            }

            return test;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int create(Test test) {

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO test ( id_test,name,description,id_staff) VALUES (DEFAULT,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, test.getName());
            preparedStatement.setString(2, test.getDescription());
            preparedStatement.setLong(3, test.getId_staff());

            int resultSet = preparedStatement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Test> findAll() {
        try {
            String query = "select * from test";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Test> listTest = new ArrayList<>();
            while (resultSet.next()) {

                listTest.add(new Test(
                        resultSet.getInt("id_test"),
                        resultSet.getString("name"),

                        resultSet.getString("description"),

                        resultSet.getInt("id_staff")
                ));
            }

            return listTest;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Test find(int id) {

        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM test where id_test=? ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Test tsa = null;
            while (resultSet.next()) {

                tsa = new Test();
                tsa.setId_test(resultSet.getInt("id_test"));
                tsa.setName(resultSet.getString("name"));
                tsa.setDescription(resultSet.getString("description"));
                tsa.setId_staff(resultSet.getInt("id_staff"));

                tsa.setQuestions(((QuestionDaoImpl) DaoFactory.getQuestionImpl()).findByTest(id));
                return tsa;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Test obj) {
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE from test where id_test=?");
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
    public Test login(Test obj) {
        return null;
    }




}