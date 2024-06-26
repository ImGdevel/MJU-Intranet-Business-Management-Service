package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "상세평가")
@IdClass(EvalDetailID.class)
@ToString
public class EvalDetail {

    @Id
    @JoinColumn(name ="평가번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long eval_num;

    @Id
    @Column(name = "평가항목", columnDefinition = "NUMBER(2,0)")
    @ApiModelProperty(example = "1")
    private Long eval_type;

    @Column(name = "평가내용", columnDefinition = "VARCHAR(500)")
    @ApiModelProperty(example = "10001")
    private Long proj_num;

    @Column(name = "평점", columnDefinition = "NUMBER(2,1)")
    @ApiModelProperty(example = "11")
    private Long eval_rate;
}
