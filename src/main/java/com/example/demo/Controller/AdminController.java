package com.example.demo.Controller;

import com.example.demo.Helper.HelperException;
import com.example.demo.Helper.ResultData;
import com.example.demo.Model.userDetails;

import com.example.demo.Repository.UserDetailsRepository;
import com.example.demo.Services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class AdminController {
@Autowired public UserDetailsService userDetailsService;
    //------------------All User-------------------------
    @Autowired
public UserDetailsRepository userDetailsRepository;
    @GetMapping("/getAllUser")
    public List<userDetails> getAllUser()
    {
        List usr = userDetailsService.getAllUserRecords();
        return usr;
    }
    //------------------Delete User-------------------------
    @DeleteMapping("/DeleteUser/{user_id}")
    public ResponseEntity DeleteUser(@PathVariable("user_id") int user_id) throws HelperException {
        ResultData result=new ResultData();
        try {


            if(!userDetailsRepository.findById(user_id).isPresent())
            {
                result.success="Fail";
            }
            List usr = userDetailsService.deleteUser(user_id);
            result.success="success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //------------------Update User-------------------------
    @PostMapping("/UpdateUser/{user_id}")
    public List<userDetails> UpdateUser(@RequestBody userDetails userDetails)
    {
        userDetailsService.UpdateUser(userDetails);
        List usr = userDetailsService.getAllUserRecords();
        return usr;
    }
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody userDetails userDetails) {
        ResultData result = new ResultData();

        if (userDetailsRepository.findById(userDetails.getUser_id()).isPresent()) {
            result.error = "Already exist";
        } else {
            userDetailsService.addUser(userDetails);
            List usr = userDetailsService.getAllUserRecords();
            result.success = "added";

        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/getAllUserCount")
    public List<userDetails> getAllUserCount(userDetails userDetails)
    {
        List usr = userDetailsService.getAllUserCount(userDetails.getUser_id());
        return usr;
    }
    //------------------Add Employee & Address into table------------------------------


}



