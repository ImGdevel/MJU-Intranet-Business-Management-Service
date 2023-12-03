package com.mjudb.officeservice.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class CareerID implements Serializable {
    @Column(name = "직원번호")
    private Long emp_num;
    @Column(name = "경력번호")
    private Long cr_num;
}
