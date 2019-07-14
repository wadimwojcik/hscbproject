package org.hsbc.wojcik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="EMPLOYEE")
public class Employee{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @Column(name="employeeName")
    String employeeName;

    @Column(name="employeeSurname")
    String employeeSurname;

    @Column(name="employeeGrade")
    int employeeGrade;

    @Column(name="employeeSalary")
    int employeeSalary;

    public Employee() {
        super();
    }

    public Employee(String employeeName, String employeeSurname, int employeeGrade, int employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeGrade = employeeGrade;
        this.employeeSalary = employeeSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public int getEmployeeGrade() {
        return employeeGrade;
    }

    public void setEmployeeGrade(int grade) {
        this.employeeGrade = grade;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                employeeGrade == employee.employeeGrade &&
                employeeSalary == employee.employeeSalary &&
                employeeName!= null && (employeeName.equals(employee.employeeName)) &&
                employeeSurname !=null && (employeeSurname.equals(employee.employeeSurname));
    }

    @Override
    public int hashCode() {
        return    (int) id * employeeName.hashCode() * employeeSurname.hashCode() * employeeGrade * employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                ", employeeGrade=" + employeeGrade +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}