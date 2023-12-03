package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "일정")
@IdClass(ScheduleID.class)
@ToString
public class Schedule {
    @Id
    @Column(name ="일정번호", columnDefinition = "NUMBER(10,0)")
    @ApiModelProperty(example = "0123456789")
    private Long sche_num;

    @Id
    @JoinColumn(name ="직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long emp_num;

    @Column(name = "시작일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023-10-11")
    private String sche_start_date;

    @Column(name = "종료일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023-10-11")
    private String sche_end_date;

    @Column(name = "일정내용", columnDefinition = "VARCHAR2(50)")
    @ApiModelProperty(example = "뭔가 일정같은 내용")
    private String sche_contents;
}
