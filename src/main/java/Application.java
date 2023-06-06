import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String password = "Vodafone40";


        try ( Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT first_name, last_name, gender, city_name FROM employee INNER JOIN city ON employee.city_id = city.city_id WHERE id = (?)")) {
            statement.setInt(1,5);
             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String employeeName = "Name: " + resultSet.getString("first_name");
                String employeeLastName = "Last name: " + resultSet.getString("last_name");
                String employeeGender = "Gender: " + resultSet.getString("gender");
                String employeeCity = "City: " + resultSet.getString("city_name");
                System.out.println(employeeName);
                System.out.println(employeeLastName);
                System.out.println(employeeGender);
                System.out.println(employeeCity);
            }
        }

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);


            Employee employee = new Employee(8, "Marina", "Gebels", "Woman", 44, 1);
            employeeDAO.create(employee);
            System.out.println(employeeDAO.readById(5));

            List<Employee> employeeList = new ArrayList<>(employeeDAO.readAll());
            for (Employee employees : employeeList) {
                System.out.println(employees);

                employeeDAO.updateEmployeeById(8, "Ekaterina", "Myshkina", "Woman", 22, 3);

                employeeDAO.deleteById(8);
            }
        }
    }
}

