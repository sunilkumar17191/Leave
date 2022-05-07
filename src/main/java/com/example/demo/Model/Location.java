package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int location_id;
    private String location_mark;
    // Many Location can be available in one city
    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

}
