package com.mjudb.officeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class ScheduleID implements Serializable {
    @Column(name = "일정번호")
    private Long sche_num;
    @Column(name = "직원번호")
    private Long emp_num;

}
