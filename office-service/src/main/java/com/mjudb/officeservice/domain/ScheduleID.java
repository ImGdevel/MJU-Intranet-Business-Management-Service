package com.mjudb.officeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class ScheduleID implements Serializable {
    private Long sche_num;
    private Long emp_num;

}
