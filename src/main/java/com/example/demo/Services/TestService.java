package com.example.demo.Services;

import com.example.demo.Model.Test;
import com.example.demo.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service


public class TestService {
@Autowired public TestRepository testRepository;
    public ArrayList<Test> getAllTestData() {
        ArrayList<Test> test = new ArrayList<>();
        testRepository.findAll().forEach(test::add);
        return test;
    }

    public void saveAllTestData(Test test) {
        testRepository.save(test);
    }

    public void deleteTestData(int test_id)
    {
        testRepository.deleteById(test_id);
    }

    public void updateTestData(Test test){
        testRepository.save(test);
    }

  /*  public List<Test> getById( int test_id)
    {
        return testRepository.findById(test_id);
    }*/
}
