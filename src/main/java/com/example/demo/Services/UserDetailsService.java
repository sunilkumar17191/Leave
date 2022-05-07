package com.example.demo.Services;

import com.example.demo.Model.Employee;
import com.example.demo.Model.userDetails;
import com.example.demo.Repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsService {
    @Autowired UserDetailsRepository userDetailsRepository;
    public List<userDetails> getAllUserRecords() {
        List<userDetails>usr = new ArrayList<>();
        // System.out.println("--"+employeeRepository.findAll());
        userDetailsRepository.findAll().forEach(usr::add);
        return usr;
    }


    public List deleteUser(int user_id) {
        userDetailsRepository.deleteById(user_id);
        List<userDetails>usr = new ArrayList<>();
        userDetailsRepository.findAll().forEach(usr::add);
        return usr;
    }

    public void UpdateUser(userDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    public void addUser(userDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }


    public List getAllUserCount(int user_id) {
        return userDetailsRepository.getAllUserCount(user_id);

    }
}
