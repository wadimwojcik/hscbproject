package org.hsbc.wojcik.dao;

import org.hsbc.wojcik.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployee() ;

    public Employee getEmployee(int id) ;

    public Employee addEmployee(Employee employee);

    public void updateEmployee(Employee employee) ;

    public void deleteEmployee(int id) ;

    public List<Employee> findEmployeesByParameters(Integer id, String name, String surname,Integer salary, Integer grade);
}
