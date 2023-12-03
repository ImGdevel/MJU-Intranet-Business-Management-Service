package com.mjudb.officeservice.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class ScheduleID implements Serializable {
    private Long sche_num;
    private Long emp_num;
}
