package com.example.demo.Repository;

import com.example.demo.Model.userDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDetailsRepository extends JpaRepository<userDetails,Integer>
{
  /*  @Query(value = "select distinct count(pg_id) from paying_guest pg " +
            "inner join grubstay.sub_location sb on sb.sub_location_id = pg.sub_location_sub_location_id " +
            "inner join grubstay.location l on l.location_id = sb.location_location_id " +
            "inner join grubstay.city c on c.city_id = l.city_city_id and c.city_name = ?1", nativeQuery = true)
    public int getAllUserCount(String cityName);*/
    @Query(value = "select * from employee e  right join  address a on  e.employeeid = a.empid " +
            "where  ",nativeQuery = true)
    List getAllUserCount(int user_id);
}
