package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "동료평가")
@ToString
public class PeerEval {
    @Id
    @JoinColumn(name ="평가번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long eval_num;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "평가자_동료", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "11")
    private Employee emp_num;
}
