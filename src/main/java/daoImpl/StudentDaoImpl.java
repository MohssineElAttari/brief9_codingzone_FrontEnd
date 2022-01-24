package daoImpl;

import dao.DAO;

import models.Student;
import models.TestStudentAnswer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends DAO<Student> {
    @Override
    public Student login(Student obj) {
        return null;
    }

    @Override
    public int create(Student obj) {
        return 0;
    }

    @Override
    public List<Student> findAll() {
        try {
            String query = "select * from student";

            PreparedStatement preparedStatement =this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> listStudent = new ArrayList<Student>();
            while (resultSet.next()) {
                listStudent.add(new Student(
                        resultSet.getInt("id_student"),
                        resultSet.getString("firstname_student"),
                        resultSet.getString("lastname_student"),
                        resultSet.getString("email")));
            }
            return listStudent;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student find(int id) {
        try {


            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM student where id_student=? ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Student s = null;
            while (resultSet.next()) {

               s = new Student();
                s.setId_student(resultSet.getInt("id_student"));
                s.setFistNameStudent(resultSet.getString("firstname_student"));
                s.setLastNameStudent(resultSet.getString("lastname_student"));
                s.setEmail(resultSet.getString("email"));
                return s;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Student obj) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
