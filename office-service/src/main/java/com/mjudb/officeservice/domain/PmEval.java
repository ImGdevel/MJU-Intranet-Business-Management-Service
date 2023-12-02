package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PM평가")
@ToString
public class PmEval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="평가번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long eval_num;

    @Column(name = "평가자_PM", columnDefinition = "NUMBER")
    @ApiModelProperty(example = "12")
    private Long PM_num;

}
