import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {
//
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//
//       Employee employee1 = new Employee(1, "Mihail", "Mihailov", "Man", 56, 2);
//        employeeDAO.create(employee1);
//
//        System.out.println(employeeDAO.readById(5));
//
//        List<Employee> list = employeeDAO.readAll();
//        for (Employee employee : list) {
//            System.out.println(employee);
//        }
//
//        Employee employee2 = new Employee(7, "Irina", "Ivanova", "Woman", 8, 2);
//        employeeDAO.update(employee2);
//
//        employeeDAO.deleteById(10);


        CityDAO cityDAO = new CityDAOImpl();

        City cityNew = new City();
        cityNew.setCityName("Воронеж");
        cityDAO.create(cityNew);

        System.out.println(cityDAO.readById(3));

        List<City> list = cityDAO.readAll();
        for (City city : list) {
            System.out.println(city);
        }

        City update = cityDAO.readById(3);
        update.setCityName("Владивосток");

        City deleteCity = cityDAO.readById(3);
        cityDAO.delete(deleteCity);
    }
}

