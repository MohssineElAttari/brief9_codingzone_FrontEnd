package models;

import java.sql.Date;

public class TestStudent {
    private int idTestStudent;
    private int idTest;
    private int idStudent;
    private Date dateTest;
    private String code;
    private Date datelimite;
    private int score;
    private int fullScore;

    public TestStudent(int idTestStudent, int idTest, int idStudent, Date dateTest, String code, Date datelimite,int score, int fullScore) {
        this.idTestStudent = idTestStudent;
        this.idTest = idTest;
        this.idStudent = idStudent;
        this.dateTest = dateTest;
        this.code = code;
        this.datelimite = datelimite;
        this.score=score;
        this.fullScore=fullScore;
    }

    public  TestStudent(){

    }


    public TestStudent(int idtest, int id_stdint, Date datelimite, String code) {

        this.idTest= idtest;
        this.idStudent=id_stdint;
        this.datelimite=datelimite;
        this.code = code;
    }

    public int getIdTestStudent() {
        return idTestStudent;
    }

    public void setIdTestStudent(int idTestStudent) {
        this.idTestStudent = idTestStudent;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(Date datelimite) {
        this.datelimite = datelimite;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFullScore() {
        return fullScore;
    }

    public void setFullScore(int fullScore) {
        this.fullScore = fullScore;
    }
}
