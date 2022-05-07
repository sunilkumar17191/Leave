package com.example.demo.Model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {

    @Id
    private int test_id;

    private String test_name;
    private int test_age;
    private int test_salary;

    public Test()
    {

    }
    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public int getTest_age() {
        return test_age;
    }

    public void setTest_age(int test_age) {
        this.test_age = test_age;
    }

    public int getTest_salary() {
        return test_salary;
    }

    public void setTest_salary(int test_salary) {
        this.test_salary = test_salary;
    }


}
