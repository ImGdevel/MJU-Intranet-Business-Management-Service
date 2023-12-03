package com.mjudb.officeservice.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EvalDetailID implements Serializable {
    private Long eval_num;
    private Long eval_type;
}
