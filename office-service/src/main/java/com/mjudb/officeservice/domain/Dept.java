package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "부서")
@ToString
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="부서번호", columnDefinition = "NUMBER(3,0)")
    @ApiModelProperty(example = "101")
    private Long dept_num;

    @Column(name = "부서명", columnDefinition = "VARCHAR(50)")
    @ApiModelProperty(example = "개발")
    private String dept_name;

    @Column(name = "부서위치", columnDefinition = "VARCHAR(6)")
    @ApiModelProperty(example = "D64133")
    private String dept_loc;

    @Column(name = "담당업무", columnDefinition = "VARCHAR(50)")
    @ApiModelProperty(example = "소프트웨어 개발")
    private String dept_role;

    @Column(name = "부서전화번호", columnDefinition = "VARCHAR(20)")
    @ApiModelProperty(example = "031)1234-4567")
    private String dept_phone_num;
}
