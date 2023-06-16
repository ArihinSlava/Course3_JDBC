package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void update(Employee employee);

    void delete(Employee employee);

    void deleteById(int id);
}
