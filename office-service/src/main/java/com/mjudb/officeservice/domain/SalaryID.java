package com.mjudb.officeservice.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SalaryID implements Serializable {
    private Long emp_num;
    private String sal_date;
}
