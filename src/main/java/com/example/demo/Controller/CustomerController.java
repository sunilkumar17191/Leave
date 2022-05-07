package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Services.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    public CustomerRepository customerRepository;
    @PostMapping("/AddCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
    {
        String message = "";
        try{

            if(customerRepository.findById(customer.getId()).isPresent())
            {
                message = "Already Exist";
            }
            else {
                customerService.addData(customer);
                message = "Saved";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(message, HttpStatus.OK);

    }
    @GetMapping("/dummydata/{name}")
    public ResponseEntity<?> getDummyData(@PathVariable ("name") String name)
    {
        List customerlist = new ArrayList();
        List customerlist1 = new ArrayList();
        Map<String,Object> map= new HashMap<>();
        List l1 = new ArrayList();
        try {
            if (name!=null)
            {
                customerlist =  customerService.manipulateData( name);
                map.put("CustomerList",customerlist);
                customerlist1 =  customerService.manipulateData( name);
                map.put("CustomerList2",customerlist);

                if(customerlist.equals(customerlist1))
                {
                    System.out.println("same");
                }

            }

            else{
                map.put("Name is null",null);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(map,HttpStatus.OK);
    }

}
