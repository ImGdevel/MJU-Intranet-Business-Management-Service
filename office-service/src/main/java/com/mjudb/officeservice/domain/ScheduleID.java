package com.mjudb.officeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class ScheduleID implements Serializable {
    private Long sche_num;
    private Long emp_num;

}
