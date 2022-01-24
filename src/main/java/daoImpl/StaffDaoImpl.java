package daoImpl;

import dao.DAO;
import models.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StaffDaoImpl extends DAO<Staff> {


    public Staff login(Staff staff) {
        Staff staffr = null;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  staff WHERE email = ? and password = ?");
            preparedStatement.setString(1, staff.getEmail());
            preparedStatement.setString(2, staff.getPassword());


            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                staffr = new Staff();
                staffr.setEmail(resultSet.getString("email"));
                staffr.setFirstname_staff(resultSet.getString("firstname_staff"));
                staffr.setId(resultSet.getInt("id_staff"));
                return staffr;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return staffr;
    }

    @Override
    public int create(Staff obj) {
        return 0;
    }

    @Override
    public List<Staff> findAll() {
        return null;
    }

    @Override
    public Staff find(int id) {
        return null;
    }

    @Override
    public int update(Staff obj) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }


}
