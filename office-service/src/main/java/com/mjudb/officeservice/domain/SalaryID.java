package com.mjudb.officeservice.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class SalaryID implements Serializable {
    @Column(name = "직원번호")
    private Long emp_num;
    @Column(name = "급여일자")
    private String sal_date;
}
