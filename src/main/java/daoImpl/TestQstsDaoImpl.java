package daoImpl;

import dao.DAO;
import models.TestQuestion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TestQstsDaoImpl extends DAO<TestQuestion> {



    @Override
    public int create(TestQuestion testqst) {
        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement("INSERT INTO test_question ( id_test,id_question) VALUES (?,?);");
            preparedStatement.setLong(1,testqst.getId_test());
            preparedStatement.setLong(2,testqst.getId_question());

            int resultSet = preparedStatement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }



    @Override
    public List<TestQuestion> findAll() {
        return null;
    }

    @Override
    public TestQuestion find(int id) {
        return null;
    }

    @Override
    public int update(TestQuestion obj) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public TestQuestion login(TestQuestion obj) {
        return null;
    }
}
