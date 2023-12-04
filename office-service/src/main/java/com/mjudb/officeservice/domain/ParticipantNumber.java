package com.mjudb.officeservice.domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "프로젝트참여자수")
@ToString
public class ParticipantNumber {
    @Id
    @Column(name ="프로젝트번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long proj_num;

    @Column(name = "참여자수", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "1")
    private Long participant_num;
}
