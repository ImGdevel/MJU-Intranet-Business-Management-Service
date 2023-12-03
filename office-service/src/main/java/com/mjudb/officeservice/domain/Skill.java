package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "기술")
@IdClass(SkillID.class)
@ToString
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="기술번호", columnDefinition = "NUMBER(2,0)")
    @ApiModelProperty(example = "11")
    private Long skill_num;

    @Id
    @JoinColumn(name ="직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long emp_num;

    @Column(name = "기술등급", columnDefinition = "NUMBWE(1,0)")
    @ApiModelProperty(example = "2")
    private Long skill_level;
}
