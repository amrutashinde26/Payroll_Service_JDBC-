package Payroll_jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpPayroll_JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root"; // Ensure this is your MySQL username
        String password = "******"; // Replace with your actual password
        String query = "SELECT * FROM payroll_service"; // Ensure this table exists

        // Use try-with-resources to ensure resources are closed properly
        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Process the result set
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String gender = resultSet.getString("gender");
                    Double salary = resultSet.getDouble("salary");
                    String start = resultSet.getString("start");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    String department = resultSet.getString("department");
                    int basicPay = resultSet.getInt("basic_pay");
                    int deduction = resultSet.getInt("deduction");
                    int taxablePay = resultSet.getInt("taxable_pay");
                    int incomePay = resultSet.getInt("income_pay");
                    int netPay = resultSet.getInt("net_pay");

                    // Print the retrieved data
                    System.out.printf("ID: %d, Name: %s, Gender: %s, Salary: %.2f, Start Date: %s, Phone: %s, Address: %s, Department: %s, Basic Pay: %d, Deduction: %d, Taxable Pay: %d, Income Pay: %d, Net Pay: %d%n",
                            id, name, gender, salary, start, phone, address, department, basicPay, deduction, taxablePay, incomePay, netPay);
                }

            } catch (SQLException e) {
                System.out.println("SQL Exception occurred.");
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        }
    }
}
