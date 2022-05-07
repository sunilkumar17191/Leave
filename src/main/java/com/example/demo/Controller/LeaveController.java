package com.example.demo.Controller;

import com.example.demo.Model.Leave;
import com.example.demo.Repository.LeaveRepository;
import com.example.demo.Services.LeaveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class LeaveController {
    @Autowired public LeaveService leaveService;
    @Autowired public LeaveRepository leaveRepository;
    @PostMapping("/AddLeaveData")
    public ResponseEntity<?> addLeaveData(@RequestBody Leave leave)
    {
        String message="";
       try {
           if(leaveRepository.findById(leave.getEmployee_id()).isPresent())
           {
              message = "Data already Exist";
           }
           else
           {
               leaveService.addLeaveData(leave);
               message = "Data Saved successfully";

           }

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        return new ResponseEntity<>(message, HttpStatus.OK );
    }
    //----------------------------------------------------------
    @GetMapping("/GetAllLeave")
    public ResponseEntity<?> GetAllLeave()
    {
        ArrayList list = new ArrayList();
        String message ="";
        try{
             list = leaveService.getAllLeave();
            if(list.size()<=0)
            {
                message = "Records does not Exist !";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if(message=="")
        {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(message,HttpStatus.OK);
        }

    }
    //----------------------------------------------------------
@GetMapping("/getOneLeave/{employee_id}")
    public ResponseEntity<?> getOneLeaveData(@PathVariable("employee_id") int employee_id)
{
    List list = new ArrayList();
    try{
        if(leaveService.getOneLeaveData(employee_id).isPresent())
        {
            list = Collections.singletonList(leaveService.getOneLeaveData(employee_id));
        }
        else {
            list.add("No record found !");
        }

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return new ResponseEntity<>(list,HttpStatus.OK);
}
@PostMapping("/UpdateLeaveData")
    public ResponseEntity<?> updateLeaveData(@RequestBody Leave leave)
{
    List list = new ArrayList();
    String message="";
    try{
        if( leaveRepository.findById(leave.getEmployee_id()).isPresent())
        {
            leaveService.updateLeaveData(leave);
            message = "Record Updated Successfully";
        }
        else {
            message = "Record does not Exist !";
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return new ResponseEntity<>(message,HttpStatus.OK);
}
@DeleteMapping("/deleteLeaveData")
    public ResponseEntity<?> deleteLeaveData(@RequestBody Leave leave)
{
    String message = "";
    try {
        if(leaveRepository.findById(leave.getEmployee_id()).isPresent())
        {
            leaveService.deleteLeaveData(leave);
            message = "Delete successfully";
        }
        else {
            message = "Record does not exist !";
        }

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return new ResponseEntity<>(message,HttpStatus.OK);
}
@PostMapping("/empLeaveGrid/{company_id}")
//    public ResponseEntity<?> getOneLeaveData(@PathVariable("employee_id") int employee_id)
    public ResponseEntity<?> getEmpLeaveGrid(@RequestBody String leaveGriddata, @PathVariable("company_id") int company_id)
{
    Map<String, Object> mapData = new HashMap<>();
    List<Map> list = new ArrayList<>();
    // int co = company_id;
    try {
        mapData = new ObjectMapper().readValue(leaveGriddata, mapData.getClass());
         list = leaveService.getEmpLeaveGrid(mapData,company_id);
       // System.out.println(mapData);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return new ResponseEntity<>(list,HttpStatus.OK);
}
@GetMapping("/DepotQuotaList/{company_id}/{depot_code}/{start_date}/{employee_id}")
    public ResponseEntity<?> getDepotQuotaList(
        @PathVariable("company_id") int compamy_id,
        @PathVariable("depot_code") String depot_code,
        @PathVariable("start_date") String start_date,
        @PathVariable("employee_id") int employee_id
                                               )
{
    List<Map> list =new ArrayList<>();
    try {
        list = leaveService.getDepotQuotaList(compamy_id,depot_code,start_date,employee_id);
        System.out.println(list);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return new ResponseEntity<>(list,HttpStatus.OK);
}
@GetMapping("/timeResponse")
    public ResponseEntity<?> gettimeResponse()
{
    String currentDate = null;
    try {
        currentDate = leaveService.gettimeResponse();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return new ResponseEntity<>(currentDate,HttpStatus.OK);
}
@PostMapping("/employeeResponse/{company_id}")
    public ResponseEntity<?> getEmployeeResponse(@RequestBody String stringData,@PathVariable("company_id") int company_id )
{
    Map<String, Object> mapData = new HashMap<>();
    List<Map> list = new ArrayList<>();
  try {
      mapData = new ObjectMapper().readValue(stringData, mapData.getClass());

    list =  leaveService.getEmployeeResponse(mapData,company_id);
  }
  catch (Exception e)
  {
      e.printStackTrace();
  }
    return new ResponseEntity<>(list,HttpStatus.OK);
}
}
