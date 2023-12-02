package com.mjudb.officeservice.domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;

@Data
@NoArgsConstructor
public class EvalDetailKey implements Serializable {
    private Long emp_num;
    private String sal_date;
}
