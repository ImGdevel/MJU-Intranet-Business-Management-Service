package com.mjudb.officeservice.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AttendanceID implements Serializable {
    @Column(name = "날짜")
    private String date;
    @Column(name = "직원번호")
    private Long emp_num;

}
