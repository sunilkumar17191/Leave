package com.example.demo.Repository;

import com.example.demo.Model.Book;
import com.example.demo.Model.City;
import com.example.demo.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository  extends JpaRepository<Location,Integer> {
}
