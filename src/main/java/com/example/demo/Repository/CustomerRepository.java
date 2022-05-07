package com.example.demo.Repository;

import com.example.demo.Controller.CustomerController;
import com.example.demo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   // @Query(value="select * from customer where name = ?1", nativeQuery = true)
    @Query(value="select * from customer", nativeQuery = true)
    public List<?> getAllCustomerData(String name);

}
