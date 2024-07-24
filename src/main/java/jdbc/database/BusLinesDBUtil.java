package jdbc.database;

import jdbc.main.*;
import jdbc.object.*;

import java.sql.*;
import java.util.ArrayList;

public class BusLinesDBUtil {
    //  Read data from table and create lines' information list
    public static ArrayList<BusLines> readData() {
        ArrayList<BusLines> lineList = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);
            Statement statement = con.createStatement();

            ResultSet result = statement.executeQuery(Constant.LINE_QUERY);

            while (result.next()) {
                int id = result.getInt(1);
                double distance = result.getDouble(2);
                int busStop = result.getInt(3);

                BusLines line = new BusLines(id, distance, busStop);
                lineList.add(line);
            }
        } catch (SQLException e) {
            System.out.println();
        }

        return lineList;
    }

    // Insert line's data in table
    public static void writeData(BusLines line) {
        try {
            Connection con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);

            String query = "INSERT INTO line VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, line.getLineId());
            statement.setDouble(2, line.getDistance());
            statement.setInt(3, line.getBusStop());
            statement.execute();

        } catch (SQLException e) {
            System.out.println();
        }
    }
}
