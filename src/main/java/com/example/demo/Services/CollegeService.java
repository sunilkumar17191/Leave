package com.example.demo.Services;

import com.example.demo.Model.College;
import com.example.demo.Repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    @Autowired
    CollegeRepository collegeRepository;
    public void addCollege(College college) {
        collegeRepository.save(college);
    }
}
