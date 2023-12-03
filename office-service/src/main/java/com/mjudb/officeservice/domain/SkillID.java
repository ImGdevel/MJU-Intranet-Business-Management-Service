package com.mjudb.officeservice.domain;
import lombok.Data;
import java.io.Serializable;

@Data
public class SkillID implements Serializable {
    private Long skill_num;
    private Long emp_num;
}
