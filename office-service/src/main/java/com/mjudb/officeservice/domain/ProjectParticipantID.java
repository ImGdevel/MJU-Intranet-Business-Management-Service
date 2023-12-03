package com.mjudb.officeservice.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProjectParticipantID implements Serializable {
    @Column(name = "프로젝트번호")
    private Long proj_num;
    @Column(name = "직원번호")
    private Long emp_num;
}
