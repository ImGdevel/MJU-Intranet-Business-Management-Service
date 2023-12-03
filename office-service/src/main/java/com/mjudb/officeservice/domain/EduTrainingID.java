package com.mjudb.officeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class EduTrainingID implements Serializable {
    @Column(name = "교육훈련번호")
    private Long eduT_num;
    @Column(name = "직원번호")
    private Long emp_num;
}
