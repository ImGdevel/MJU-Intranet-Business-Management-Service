package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "직무")
@ToString
public class Role {
    @Id
    @Column(name ="직무번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "01234")
    private Long role_num;

    @Column(name ="직무이름", columnDefinition = "VARCHAR2(50)")
    @ApiModelProperty(example = "PM")
    private String role_name;
}
