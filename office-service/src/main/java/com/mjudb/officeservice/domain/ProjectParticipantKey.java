package com.mjudb.officeservice.domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Data
@NoArgsConstructor
public class ProjectParticipantKey implements Serializable {
    private Long proj_num;
    private Long emp_num;
}
