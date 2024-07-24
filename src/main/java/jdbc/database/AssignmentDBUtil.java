package jdbc.database;

import jdbc.control.*;
import jdbc.main.*;
import jdbc.object.*;

import java.sql.*;
import java.util.ArrayList;

public class AssignmentDBUtil {
    //  Read data from table and create assignment's information list
    public static ArrayList<AssignmentBoard> readData() {
        ArrayList<AssignmentBoard> assignmentList = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);
            Statement statement = con.createStatement();

            ResultSet result = statement.executeQuery(Constant.ASSIGNMENT_QUERY);

            while (result.next()) {
                int driverId = result.getInt(2);
                int lineId = result.getInt(3);
                int turns = result.getInt(4);

                BusDriver driver = DriverControl.findById(driverId);
                BusLines line = LineControl.findById(lineId);

                if ((driver != null) && (line != null)) {
                    assignmentList.add(new AssignmentBoard(driver, line, turns));
                }
            }
        } catch (SQLException e) {
            System.out.println();
        }

        return assignmentList;
    }

    // Insert assignment's data in table
    public static void writeData(AssignmentBoard assignment) {
        try {
            Connection con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);

            String query = "INSERT INTO assignment (driver_id, line_id, turns) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, assignment.getDriver().getLxId());
            statement.setInt(2, assignment.getLine().getLineId());
            statement.setInt(3, assignment.getTurns());
            statement.execute();

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public static void updateData(AssignmentBoard assignment) {
        try {
            Connection con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);

            String query = "UPDATE assignment SET turns = ? WHERE driver_id = ? and line_id = ?";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, assignment.getTurns());
            statement.setInt(2, assignment.getDriver().getLxId());
            statement.setInt(3, assignment.getLine().getLineId());
            statement.execute();

        } catch (SQLException e) {
            System.out.println();
        }
    }
}