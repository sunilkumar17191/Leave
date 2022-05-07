package com.example.demo.Services;

import com.example.demo.Controller.CityController;
import com.example.demo.Model.City;
import com.example.demo.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    public   CityRepository cityRepository;
    public void addCity(City city) {
       cityRepository.save(city);
    }

}
