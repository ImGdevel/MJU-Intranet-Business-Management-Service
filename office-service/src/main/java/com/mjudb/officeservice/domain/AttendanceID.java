package com.mjudb.officeservice.domain;
import lombok.Data;
import java.io.Serializable;

@Data
public class AttendanceID implements Serializable {
    private String date;
    private Long emp_num;

}
