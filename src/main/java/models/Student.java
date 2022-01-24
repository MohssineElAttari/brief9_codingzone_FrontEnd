package models;

public class Student {
    private int id_student;
    private String fistNameStudent;
    private String lastNameStudent;
    private String email;

    public Student() {
    }

    public Student(int id_student, String fistNameStudent, String lastNameStudent, String email) {
        this.id_student = id_student;
        this.fistNameStudent = fistNameStudent;
        this.lastNameStudent = lastNameStudent;
        this.email = email;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getFistNameStudent() {
        return fistNameStudent;
    }

    public void setFistNameStudent(String fistNameStudent) {
        this.fistNameStudent = fistNameStudent;
    }

    public String getLastNameStudent() {
        return lastNameStudent;
    }

    public void setLastNameStudent(String lastNameStudent) {
        this.lastNameStudent = lastNameStudent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", fistNameStudent='" + fistNameStudent + '\'' +
                ", lastNameStudent='" + lastNameStudent + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
