package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "기술분류")
@ToString
public class SkillClassification {
    @Id
    @Column(name ="기술번호", columnDefinition = "NUMBER(2,0)")
    @ApiModelProperty(example = "10")
    Long skill_num;

    @Column(name = "기술이름", columnDefinition = "VARCHAR(50)")
    @ApiModelProperty(example = "자바")
    Long skill_name;
}
