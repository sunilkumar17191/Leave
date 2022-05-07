package com.example.demo.Services;

import com.example.demo.Model.Employee;
//import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public  class employeeService {
@Autowired
EmployeeRepository employeeRepository;
   public List<Employee> getAllEmployee()
   {
      List<Employee>employees = new ArrayList<>();
     // System.out.println("--"+employeeRepository.findAll());
      employeeRepository.findAll().forEach(employees::add);
      return employees;
   }

   public List deleteEmployees( int employeeid) {
      employeeRepository.deleteById(employeeid);
      List<Employee>employees = new ArrayList<>();
      employeeRepository.findAll().forEach(employees::add);
      return employees;
   }
   public void addEmployee(Employee employee)
   {
      employeeRepository.save(employee);
   }
   public void updateEmployee( Employee employee)
   {
      employeeRepository.save(employee);
   }
}


