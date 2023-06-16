package dao;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeeDAOImpl  implements EmployeeDAO {

        @Override
        public void create (Employee employee){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(employee);
                transaction.commit();
            }
        }
        @Override
        public Employee readById ( int id){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                return session.get(Employee.class, id);
            }
        }

        @Override
        public List<Employee> readAll () {
            try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                return session.createQuery("FROM Employee").list();
            }
        }

        @Override
        public void update (Employee employee){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.update(employee);
                transaction.commit();
            }
        }

        @Override
        public void delete (Employee employee){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(employee);
                transaction.commit();
            }
        }

    @Override
    public void deleteById(int id) {
            try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                Employee deleteEmployee = session.get(Employee.class, id);
                session.delete(deleteEmployee);
                transaction.commit();
            }
    }
    }

