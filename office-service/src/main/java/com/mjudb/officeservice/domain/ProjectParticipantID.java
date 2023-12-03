package com.mjudb.officeservice.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProjectParticipantID implements Serializable {
    private Long proj_num;
    private Long emp_num;
}
