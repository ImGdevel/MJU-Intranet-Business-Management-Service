package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "평가")
@ToString
public class Eval {

    @Id
    @Column(name ="평가번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long eval_num;

    @JoinColumn(name = "프로젝트번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "10001")
    private Long proj_num;

    @JoinColumn(name = "직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "11")
    private Long emp_num;
}
