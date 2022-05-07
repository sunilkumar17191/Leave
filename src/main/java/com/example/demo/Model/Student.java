package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int student_id;
    private String student_name;
    @ManyToOne(fetch = FetchType.EAGER)
    private College college;
}
