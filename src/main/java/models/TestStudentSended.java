package models;

public class TestStudentSended{
    int id_test;
    String email;
    boolean sended;

    public int getId_test() {
        return id_test;
    }

    public String getEmail() {
        return email;
    }

    public boolean isSended() {
        return sended;
    }

    public TestStudentSended(int id_test, String email, boolean sended) {
        this.id_test = id_test;
        this.email = email;
        this.sended = sended;
    }



    @Override
    public String toString() {
        return "TestStudentSended{" +
                "id_test=" + id_test +
                ", email='" + email + '\'' +
                ", sended=" + sended +
                '}';
    }
}
