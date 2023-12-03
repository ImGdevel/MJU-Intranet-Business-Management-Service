package com.mjudb.officeservice.domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "프로젝트")
@ToString
public class Project {
    @Id
    @Column(name ="프로젝트번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long proj_num;

    @Column(name = "프로젝트명", columnDefinition = "VARCHAR(50)")
    @ApiModelProperty(example = "프로젝트1")
    private String proj_name;

    @Column(name = "프로젝트착수일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023/01/01")
    private String proj_start;

    @Column(name = "프로젝트종료일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023/01/01")
    private String proj_end;

    @Column(name = "발주처", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "imdinrks@gmail.com")
    private Long cust_num;
}
