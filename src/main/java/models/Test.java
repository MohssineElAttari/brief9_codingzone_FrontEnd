package models;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private int id_test;
    private String name;
    private String description;
    private int id_staff;


    private List<Question> questions;

    public Test(int id_test, String name, String description, int id_staff) {
        this.id_test = id_test;
        this.name = name;
        this.description = description;
        this.id_staff = id_staff;
        this.questions=new ArrayList<>();
    }
    public Test() {

    }

    public Test(String name, String description, int id_staff) {
        this.name = name;
        this.description = description;
        this.id_staff = id_staff;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }





}
