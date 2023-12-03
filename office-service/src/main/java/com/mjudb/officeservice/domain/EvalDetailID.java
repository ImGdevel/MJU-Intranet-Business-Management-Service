package com.mjudb.officeservice.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class EvalDetailID implements Serializable {
    @Column(name = "평가번호")
    private Long eval_num;
    @Column(name = "평가항목")
    private Long eval_type;
}
