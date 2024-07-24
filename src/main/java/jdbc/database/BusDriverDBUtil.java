package jdbc.database;

import jdbc.main.*;
import jdbc.object.*;

import java.sql.*;
import java.util.ArrayList;

public class BusDriverDBUtil {
    //  Read data from table and create drivers' information list
    public static ArrayList<BusDriver> readData() {
        ArrayList<BusDriver> driverList = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);
            Statement statement = con.createStatement();

            ResultSet result = statement.executeQuery(Constant.DRIVER_QUERY);

            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                String address = result.getString(3);
                String phoneNumber = result.getString(4);
                String level = result.getString(5);

                BusDriver driver = new BusDriver(id, name, address, phoneNumber, level);
                driverList.add(driver);
            }
        } catch (SQLException e) {
            System.out.println();
        }

        return driverList;
    }

    // Insert driver's data in table
    public static void writeData(BusDriver driver) {
        try {
            Connection con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);

            String query = "INSERT INTO driver VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, driver.getLxId());
            statement.setString(2, driver.getName());
            statement.setString(3, driver.getAddress());
            statement.setString(4, driver.getPhoneNumber());
            statement.setString(5, driver.getLevel());
            statement.execute();

        } catch (SQLException e) {
            System.out.println();
        }
    }
}
