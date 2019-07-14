package org.hsbc.wojcik.controller;

import java.util.List;
import java.util.Map;

import org.hsbc.wojcik.Errors.EmployeeNotFoundException;
import org.hsbc.wojcik.model.Employee;
import org.hsbc.wojcik.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Employee Controller for JSON requests and responses
 */
@RestController
public class EmployeeJsonController {

    @Autowired
    EmployeeService employeeService;

    /**
     * Get All employess in JSON format as requested in task
     * @return json list of all employess
     */
    @RequestMapping(value = "/getJsonAllEmployee", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String getJsonAllEmployee() {
        List<Employee> listOfEmployee = employeeService.getAllEmployee();
        return listOfEmployee.toString();
    }

    /**
     * Searching employee by employee id and producing results in json format
     * @param id employee id
     * @return all employee details in json/string format
     * @throws EmployeeNotFoundException when  employee wasnt found
     */
    @RequestMapping(value = "/getJsonEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String getJsonEmployeeById(@PathVariable int id) throws EmployeeNotFoundException
    {
        if(employeeService.getEmployee(id) != null) return employeeService.getEmployee(id).toString();
        else throw new EmployeeNotFoundException(id);

    }

    /**
     * Deleting employee by employee id
     * @param id employee id
     * @return json information with deleted employee id or exception message if employee not found
     */
    @RequestMapping(value = "/deleteJsonEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String deleteJsonEmployee(@PathVariable("id") int id) {
        if(employeeService.getEmployee(id) != null){
            employeeService.deleteEmployee(id);
            return "Deleted user id:" +id;
        }else throw new EmployeeNotFoundException(id);
    }

    /**
     * Multiparameter search of employee users. It can consume any parameters by GET method, so everything can be setup in the URL
     * Example of simple request: http://localhost:8080/getJsonEmployeeByCriteria?id=1&name=wadim&surname=wojcik&salary=100&grade=55
     * @param query consume URL and with parameters and adding criteria for search users
     * @return list of employees which fits to the requested parameters
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getJsonEmployeeByCriteria")
    @ResponseBody

    public String getJsonEmployeeByCriteria(@RequestParam Map<String, String> query) {
        try {
            Integer id = null;
            String name = null;
            String surname = null;
            Integer grade = null;
            Integer salary = null;
            if (query.containsKey("id")) id = Integer.parseInt(query.get("id"));
            if (query.containsKey("name")) name = query.get("name");
            if (query.containsKey("surname")) surname = query.get("surname");
            if (query.containsKey("grade"))  grade =  Integer.parseInt(query.get("grade"));
            if (query.containsKey("salary")) salary =  Integer.parseInt(query.get("salary"));
            List<Employee> listOfEmployee = employeeService.findEmployeesByParameters(id,name,surname,salary,grade);
            return listOfEmployee.toString();
        }catch (Exception e){
            return "Issues with parsing parameters";
        }
    }



}
