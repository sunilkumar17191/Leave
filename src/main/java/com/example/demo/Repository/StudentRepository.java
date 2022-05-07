package com.example.demo.Repository;

import com.example.demo.Model.College;
import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
