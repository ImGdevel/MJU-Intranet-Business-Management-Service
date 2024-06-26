package com.mjudb.officeservice.domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Entity
@Table(name = "프로젝트_참여정보")
@IdClass(ProjectParticipantID.class)
@ToString
public class ProjectParticipant {
    @Id
    @JoinColumn(name ="프로젝트번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long proj_num;

    @Id
    @JoinColumn(name ="직원번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long emp_num;

    @Column(name = "프로젝트투입일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023/01/01")
    private String proj_in;

    @Column(name = "프로젝트이탈일자", columnDefinition = "DATE")
    @ApiModelProperty(example = "2023/01/01")
    private String proj_out;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinColumn(name = "수행직무", referencedColumnName = "직무번호")
    @ApiModelProperty(example = "101")
    private Role role_num;
}