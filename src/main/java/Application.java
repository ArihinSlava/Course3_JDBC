import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

       Employee employee1 = new Employee(1, "Mihail", "Mihailov", "Man", 56, 2);
        employeeDAO.create(employee1);

        System.out.println(employeeDAO.readById(5));

        List<Employee> list = employeeDAO.readAll();
        for (Employee employee : list) {
            System.out.println(employee);
        }

        Employee employee2 = new Employee(7, "Irina", "Ivanova", "Woman", 8, 2);
        employeeDAO.update(employee2);

        employeeDAO.deleteById(10);



    }
}

