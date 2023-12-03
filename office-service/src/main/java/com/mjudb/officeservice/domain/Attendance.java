package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@IdClass(AttendanceID.class)
@ToString
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="날짜", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023-11-12")
    private String date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name ="직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long emp_num;

    @Column(name = "출근시각", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023-10-11 00:01:12")
    private String work_start_time;

    @Column(name = "퇴근시각", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023-10-11 00:11:33")
    private String work_end_time;
}
