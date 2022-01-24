package models;

import java.sql.Date;

public class TestsByDates {
    private Date date;
    private int tests;


    public TestsByDates(Date date, int tests) {
        this.date = date;
        this.tests = tests;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }
}
