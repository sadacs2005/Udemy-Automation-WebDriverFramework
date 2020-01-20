package udemyPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Practice17_MySQLDBConnaction {

    @Test
    public void connectToDB() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/QADBT";
        Connection con = DriverManager.getConnection(URL, "root", "root");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM qadbt.empdetails where EmpName='Sharath'");

        while (rs.next()) {
            System.out.println(rs.getString(2));
        }
    }

}
