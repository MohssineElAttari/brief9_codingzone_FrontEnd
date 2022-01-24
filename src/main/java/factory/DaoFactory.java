package factory;

import dao.DAO;
import daoImpl.*;
import models.*;

public class DaoFactory {


    public static DAO<Staff> getStaffImpl(){ return new StaffDaoImpl();}

    public static DAO<Question> getQuestionImpl(){return new QuestionDaoImpl();}

    public static DAO<Test> getTestImpl(){return new TestDaoImpl();}

    public static DAO<TestQuestion> getTestQstsImpl(){
        return  new TestQstsDaoImpl();
    }

    public static DAO<Student> getStudentImpl(){
        return  new StudentDaoImpl();
    }

    public static DAO<TestStudent> getTestStudentImpl(){
        return  new TestStudentDaoImpl();
    }

    public static DAO<TestStudentAnswer> getTestStudentAnswerImpl(){return  new TestStudentAnswerDaoImpl();}






}
