package models;

public class Staff {




    private int id ;
    private String firstname_staff ;
    private String lastname_staff;
    private String email ;
    private String password ;


    public Staff(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Staff() {

    }


    public Staff(String firstname_staff, String lastname_staff, String email, String password) {
        this.firstname_staff = firstname_staff;
        this.lastname_staff = lastname_staff;
        this.email = email;
        this.password = password;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname_staff() {
        return firstname_staff;
    }

    public void setFirstname_staff(String firstname_staff) {
        this.firstname_staff = firstname_staff;
    }

    public String getLastname_staff() {
        return lastname_staff;
    }

    public void setLastname_staff(String lastname_staff) {
        this.lastname_staff = lastname_staff;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
