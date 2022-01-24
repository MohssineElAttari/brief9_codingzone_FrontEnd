package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    //    private static String url = "jdbc:postgresql://localhost:5432/DBCoding";
    private static String url = "jdbc:postgresql://localhost:5432/DBCoding";
    private static String user = "postgres" ;
    private static String passwd = "root";
    private static Connection connect;

    public static Connection getInstance(){
        if(connect == null){
            try   {

                Class.forName("org.postgresql.Driver");

            }
            catch(ClassNotFoundException e) {
                System.out.println("Class not found "+ e);
            }

            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}