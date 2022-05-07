package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)

    /*private int college_id;
    private String college_name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "college", orphanRemoval = true)
    private List<Student> student = new ArrayList<>();*/
    private int college_id;
    private String college_name;
    @JoinColumn(name = "college_college_id")

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> student = new ArrayList<>();

}
