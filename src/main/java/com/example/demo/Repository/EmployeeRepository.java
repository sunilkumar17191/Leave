package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import org.springframework.data.repository.CrudRepository;
public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{

}
