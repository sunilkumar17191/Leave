package com.example.demo.Controller;

import com.example.demo.Model.Test;
import com.example.demo.Repository.TestRepository;
import com.example.demo.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class TestController {
    @Autowired
    public TestService testService;
    @Autowired
    public TestRepository testRepository;
    //  ---------------Get All Test------------------------------------------------

    @GetMapping("/GetAllTestData")
    public ResponseEntity<?> getAllTest()
    {
        ArrayList list= new ArrayList();
      try {
           list=  testService.getAllTestData();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
        if(list.size()<=0)
        {
            return new ResponseEntity<>("No Record Found",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
  //  ---------------Add Test------------------------------------------------
    @PostMapping("/AddTestData")
    public ResponseEntity<?> AddTestData(@RequestBody Test test)
    {
        String message="";
        List<Test> list = new ArrayList<>();
        try {
            if(testRepository.findById(test.getTest_id()).isPresent())
            {
                message = "Record already Exist!";
            }
            else
            {

                testService.saveAllTestData(test);
                message = "Data saved successfully!";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    //  ---------------Delete one Test------------------------------------------------
@DeleteMapping("/DeleteTestData/{test_id}")
    public ResponseEntity<?> deleteTestData(@PathVariable("test_id") int test_id)
{
    String message="";
  try {
      if (testRepository.findById(test_id).isPresent())
      {
          testService.deleteTestData(test_id);
          message = "Record has been deleted successfully";
      }
      else {
          message = "Record not present";
      }
  }
  catch (Exception e)
  {
      e.printStackTrace();
  }
  return new ResponseEntity<>(message,HttpStatus.OK);
}
    //  ---------------Update one Test------------------------------------------------
@PostMapping("/updateTestData")
    public ResponseEntity<?> updateTestData(@RequestBody Test test)
    {
        String message = "";
        try {
            if(testRepository.findById(test.getTest_id()).isPresent())
            {
                testService.updateTestData( test);
                message = "Record updated successfully!";
            }
            else {
                message = "Record not found!";
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}





























