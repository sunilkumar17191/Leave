package com.example.demo.Controller;

import com.example.demo.Model.City;
import com.example.demo.Services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {
    @Autowired
   public CityService cityService;
@PostMapping("/addCity")
    public List <CityController> addCity(@RequestBody City city){
     cityService.addCity(city);
    ArrayList list = new ArrayList();
    return list;
}
}
