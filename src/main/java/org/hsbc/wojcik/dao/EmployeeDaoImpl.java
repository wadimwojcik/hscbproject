package org.hsbc.wojcik.dao;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hsbc.wojcik.HibernateConfiguration;
import org.hsbc.wojcik.model.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<Employee> getAllEmployee() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee>  EmployeeList = session.createQuery("from Employee").list();
        return EmployeeList;
    }

    public Employee getEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        return employee;
    }

    public Employee addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(employee);
        return employee;
    }

    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        Hibernate.initialize(employee);
        session.update(employee);
    }

    public void deleteEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee p = (Employee) session.load(Employee.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }

    @Override
    public List<Employee> findEmployeesByParameters(Integer id, String employeeName, String employeeSurname, Integer salary, Integer grade) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Employee.class);
        if(id != null) cr.add(Restrictions.eq("id", id));
        if(employeeName != null) cr.add(Restrictions.eq("employeeName", employeeName));
        if(employeeSurname != null) cr.add(Restrictions.eq("employeeSurname", employeeSurname));
        if(salary != null) cr.add(Restrictions.eq("employeeSalary", salary));
        if(grade != null) cr.add(Restrictions.eq("employeeGrade", grade));
        List<Employee> results = cr.list();
        return results;
    }
}
