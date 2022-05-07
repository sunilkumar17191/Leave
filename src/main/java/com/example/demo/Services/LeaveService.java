package com.example.demo.Services;

import com.example.demo.Model.Leave;
import com.example.demo.Repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LeaveService {
    @Autowired public LeaveRepository leaveRepository;
    public void addLeaveData(Leave leave) {
        leaveRepository.save(leave);
    }
    public ArrayList<Leave> getAllLeave() {
        ArrayList<Leave> leave = new ArrayList<>();
        leaveRepository.findAll().forEach(leave::add);
        return leave;
    }
    public Optional<Leave> getOneLeaveData(int employee_id)
    {
        return leaveRepository.findById(employee_id);
    }
    public void updateLeaveData(Leave leave)
    {
        leaveRepository.save(leave);
      //  return (List<Leave>) leave;
    }
    public void deleteLeaveData(Leave leave)
    {
        leaveRepository.deleteById(leave.getEmployee_id());
    }

    public List<Map> getEmpLeaveGrid(Map<String, Object> mapData,int company_id) {
       return leaveRepository.getEmpLeaveGrid(mapData.get("authorised_flag").toString(), Integer.parseInt(mapData.get("employee_id").toString()),company_id);
    }
    public List<Map> getDepotQuotaList(int compamy_id,String depot_code,String start_date, int employee_id) throws ParseException {
        System.out.println(start_date);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = (Date)formatter.parse(start_date);

        //Date date1=new SimpleDateFormat("yyyy-MM-DD").parse(start_date);
        System.out.println(date1);
        return leaveRepository.getDepotQuotaList(compamy_id,depot_code,date1,  employee_id);
    }

    public String gettimeResponse() {
        Date date = new Date();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);

        return modifiedDate;
    }

    public List<Map> getEmployeeResponse(Map<String, Object> mapData, int company_id) {
        return leaveRepository.getEmployeeResponseData(Integer.parseInt(mapData.get("employee_id").toString()),company_id);


    }
}
