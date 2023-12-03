package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "교육훈련")
@IdClass(EduTrainingID.class)
@ToString
public class EduTraining {
    @Id
    @Column(name ="교육훈련번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "0123456789")
    private Long eduT_num;

    @Id
    @JoinColumn(name ="직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long emp_num;

    @Column(name = "교육훈련유형", columnDefinition = "VARCHAR2(50)")
    @ApiModelProperty(example = "온보딩 교육")
    private String eduT_type;

    @Column(name = "교육훈련일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023-10-11")
    private String eduT_date;

    @Column(name = "교육훈련내용", columnDefinition = "VARCHAR2(100)")
    @ApiModelProperty(example = "뭔가 훈련같은 내용")
    private String eduT_contents;
}
