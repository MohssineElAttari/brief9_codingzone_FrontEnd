package models;

public class TestStudentAnswer {
    private  int id;

    public int getId_teststudent() {
        return id_teststudent;
    }

    public void setId_teststudent(int id_teststudent) {
        this.id_teststudent = id_teststudent;
    }

    private  int id_teststudent;
    private  int id_student;
    private  int id_test;
    private  int id_question;
    private int answer;

    public TestStudentAnswer(int id,int id_teststudent, int id_student, int id_test, int id_question, int answer) {
        this.id = id;
        this.id_teststudent=id_teststudent;
        this.id_student = id_student;
        this.id_test = id_test;
        this.id_question = id_question;
        this.answer = answer;
    }

    public TestStudentAnswer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
