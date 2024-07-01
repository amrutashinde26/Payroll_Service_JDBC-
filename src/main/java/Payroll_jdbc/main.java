package Payroll_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
    String url = "jdbc:mysql://localhost:3306/payroll_service";
    String username=" root@localhost";
    String password = "Amruta@2610";

    Connection connection = null;
    public Connection getConnection()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }return connection;
    }
    public static void main(String args[])
    {
        System.out.println("JDBC PROGRAM ");
    }
}
