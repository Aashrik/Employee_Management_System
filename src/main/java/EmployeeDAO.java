
import Modules.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class EmployeeDAO {

        public void addEmployee(Employee employee) {
            try (Connection connection = DatabaseConnector.connect()) {
                String query = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, employee.getName());
                    preparedStatement.setString(2, employee.getPosition());
                    preparedStatement.setDouble(3, employee.getSalary());
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Employee> getAllEmployees() {
            List<Employee> employees = new ArrayList<>();
            try (Connection connection = DatabaseConnector.connect()) {
                String query = "SELECT * FROM employees";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Employee employee = new Employee();
                        employee.setId(resultSet.getInt("id"));
                        employee.setName(resultSet.getString("name"));
                        employee.setPosition(resultSet.getString("position"));
                        employee.setSalary(resultSet.getDouble("salary"));
                        employees.add(employee);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return employees;
        }
    }


