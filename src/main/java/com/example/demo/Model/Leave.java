package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
//@Table (name= "employee_unavail")
@Embeddable

public class Leave {
    @Id
    @Column(name = "employee_id")
    private  int employee_id;

    private  int company_id;
    private  String employee_code;
    private  String type_flag;
    private Date start_date;
    private  Date end_date;
    private  String unavail_before;
    private  String unavail_after;
    private  String unavail_day;
    private  String day_type_code;
    private  int shift_hdr_id;
    private  String unavail_notes;
    private  String duty_group_code;
    private  String usr;
    private Date change_ts;

    private  String pay_as_roster;
    private  String authorised_flag;
    private  String authorised_usr;
    private  String authorised_date;
    private  int unavailable_days;
    private  String prepaid_flag;
    private  String connx_leave_record_key;
    private  String half_pay_flag;
    private  String shift_sign_on;
    private  String shift_sign_off;
    private  Time time_from;
    private  Time time_to;
    private  int doc_id;
    private  String system_notes;
    private  String doc_status_reason;
    private  String leave_date;
    private  String leave_reason;
    private  String medical_cert;
    private  String medical_cert_date;
    private  boolean sports_club;
    private  int medical_cert_no;
    private Time hours_worked;
    private  String app_date;
    private  String auto_so_cancel;
    private  String dis_date;
    private  String nd_status;
    private  String depot_code;
    private  String issued_by;
    private  String sanction_from_date;
    private  String sanction_to_date;
    private  int sport_gm_sanction;



}
