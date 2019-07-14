package org.hsbc.wojcik.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hsbc.wojcik.dao.EmployeeDao;
import org.hsbc.wojcik.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("employeeService")
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Transactional
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Transactional
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Transactional
    public List<Employee> findEmployeesByParameters(Integer id,String name,String surname,Integer salary, Integer grade) {
        return employeeDao.findEmployeesByParameters(id,name,surname,salary,grade);
    }
}
