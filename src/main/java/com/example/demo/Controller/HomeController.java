package com.example.demo.Controller;

import com.example.demo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;

import java.util.List;
import com.example.demo.Services.employeeService;
@RestController

public class HomeController {
@Autowired
public employeeService employeeService;
    //------------------All Employee-------------------------
    @GetMapping(value = "/getEmployee")
    public List<Employee> getAllEmployee()
    {
       List employee  = employeeService.getAllEmployee();
        return employee;
    }
    //------------------Add Employee-------------------------

    @RequestMapping(value="/addEmployee", method=RequestMethod.POST)
    public void addUser(@RequestBody Employee employee)
    {
        employeeService.addEmployee(employee);
    }

    //------------------Delete Employee-------------------------

    @DeleteMapping("/deleteEmployee/{employeeid}")
    public List<Employee> deleteEmployeeId(@PathVariable("employeeid") int employeeid)
    {
        List employee  = employeeService.deleteEmployees(employeeid);
        return employee;
    }

    //------------------update Employee-------------------------

    @PostMapping("/updateEmployee/{employeeid}")
    public List<Employee> updateEmployee(@RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
        List employee1  = employeeService.getAllEmployee();
        return employee1;
    }
}

