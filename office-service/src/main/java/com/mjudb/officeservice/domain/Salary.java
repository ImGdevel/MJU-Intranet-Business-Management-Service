package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "급여")
@IdClass(SalaryID.class)
@ToString
public class Salary {
    @Id
    @JoinColumn(name ="직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long emp_num;

    @Id
    @Column(name = "급여일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023/01/01")
    private String sal_date;

    @Column(name = "기본급여", columnDefinition = "NUMBER(10,0)")
    @ApiModelProperty(example = "100000")
    private Long salary;

    @Column(name = "인센티브", columnDefinition = "NUMBER(10,0)")
    @ApiModelProperty(example = "100000")
    private Long incentive;

    @Column(name = "세금", columnDefinition = "NUMBER(10,0)")
    @ApiModelProperty(example = "100000")
    private Long tax;
}
