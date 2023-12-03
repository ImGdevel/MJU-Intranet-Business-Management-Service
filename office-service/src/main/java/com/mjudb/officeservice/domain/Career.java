package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "경력")
@IdClass(CareerID.class)
@ToString
public class Career {
    @Id
    @JoinColumn(name ="직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long emp_num;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="경력번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long cr_num;

    @Column(name = "경력내용", columnDefinition = "VACHAR2(100)")
    @ApiModelProperty(example = "A회사에서 5년근무")
    private String cr_text;

    @Column(name = "경력시작일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023-10-11")
    private String cr_start_date;

    @Column(name = "기간", columnDefinition = "NUMBER(4,0)")
    @ApiModelProperty(example = "5")
    private Long cr_period;
}
