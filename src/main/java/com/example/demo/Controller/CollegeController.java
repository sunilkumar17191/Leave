package com.example.demo.Controller;

import com.example.demo.Model.College;
import com.example.demo.Services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CollegeController {
    @Autowired
   public CollegeService collegeService;
    @PostMapping("/addCollege")
    public List<College>  addCollege(@RequestBody College college)
    {
        collegeService.addCollege(college);
        List<College> list = new ArrayList<>();
        return list;
    }
}
