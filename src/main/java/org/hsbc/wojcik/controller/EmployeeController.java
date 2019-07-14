package org.hsbc.wojcik.controller;

import java.util.List;

import org.hsbc.wojcik.model.Employee;
import org.hsbc.wojcik.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Employee Controller for jsp view.
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * Getting all employee and print them in the jsp page
     * @param model
     * @return list of employee
     */
    @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET, headers = "Accept=application/json")
    public String EmployeeController(Model model) {

        List<Employee> listOfEmployee = employeeService.getAllEmployee();
        model.addAttribute("employee", new Employee());
        model.addAttribute("listOfEmployee", listOfEmployee);
        return "employeeDetails";
    }

    /**
     * Overriding default http address with getAllEmployess results
     * @return list of all employees from method
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public String goToHomePage() {
        return "redirect:/getAllEmployee";
    }

    /**
     * Searching and returning user with requested ID
     * @param id employee ID
     * @return employee object
     */
    @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    /**
     * Creating new employee
     * @param employee parameters
     * @return back to main  and refresh getAllEmployee view.
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        if(employee.getId()==0)
        {
            employeeService.addEmployee(employee);
        }
        else
        {
            employeeService.updateEmployee(employee);
        }

        return "redirect:/getAllEmployee";
    }

    /**
     * Modyfing exisiting user
     * @param id employee_id
     * @param model modified fields of employee
     * @return employee details
     */
    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateEmployee(@PathVariable("id") int id,Model model) {
        model.addAttribute("employee", this.employeeService.getEmployee(id));
        model.addAttribute("listOfEmployee", this.employeeService.getAllEmployee());
        return "employeeDetails";
    }

    /**
     * Removing user by ID
     * @param id employee_id
     * @return back to main page and refresh getAllEmployee view
     */
    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/getAllEmployee";

    }
}
