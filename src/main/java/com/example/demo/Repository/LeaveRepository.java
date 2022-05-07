package com.example.demo.Repository;

import com.example.demo.Model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Repository

public interface LeaveRepository extends JpaRepository<Leave,Integer> {
    @Modifying
    @Transactional
    @Query(value="select * from Leave where authorised_flag = ?1 and employee_id = ?2 and company_id = ?3  ", nativeQuery = true)
    public List<Map> getEmpLeaveGrid( String authorised_flag, int employee_id, int company_id);

    @Query(value = "select * from leave where company_id = ?1 and " +
            " depot_code = ?2  and start_date = ?3 and employee_id = ?4",nativeQuery = true)
    List<Map> getDepotQuotaList(int company_id, String depot_code,Date date1 , int employee_id);


    @Query(value = "select * from leave where employee_id = ?1 and company_id = ?2 ",nativeQuery = true)
   public List<Map> getEmployeeResponseData( int employee_id, int company_id);

}
