package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "직원")
@ToString
public class Employee {
    @Id
    @Column(name ="직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long emp_num;

    @Column(name = "직원명", columnDefinition = "VARCHAR2(50)")
    @ApiModelProperty(example = "서원우")
    private String emp_name;

    @Column(name = "주민등록번호", columnDefinition = "VACHAR2(14)")
    @ApiModelProperty(example = "001212-1231234")
    private String person_num;

    @Column(name = "최종학력", columnDefinition = "VARCHAR2(50)")
    @ApiModelProperty(example = "대학교 졸업(컴퓨터 비전)")
    private String edu_level;

    @Column(name = "직위", columnDefinition = "VARCHAR2(50)")
    @ApiModelProperty(example = "부장")
    private String position;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Dept.class)
    @JoinColumn(name = "소속부서", referencedColumnName = "부서번호")
    @ApiModelProperty(example = "103")
    private Dept dept_num;

    @Column(name = "정보권한등급", columnDefinition = "NUMBER(1,0)")
    @ApiModelProperty(example = "2")
    private String security_level;
}
