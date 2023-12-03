package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "회원정보")
@ToString
public class MemInfo {
    @Id
    @Column(name ="id", columnDefinition = "VARCHAR(20)")
    @ApiModelProperty(example = "SH WOO")
    private String id;

    @JoinColumn(name = "직원사번", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "11")
    private Long emp_num;

    @Column(name = "비밀번호", columnDefinition = "VARCHAR(20)")
    @ApiModelProperty(example = "qwerty123")
    private String passwd;

    @Column(name = "전화번호", columnDefinition = "VARCHAR(20)")
    @ApiModelProperty(example = "010-1234-4567")
    private String phone_num;

    @Column(name = "생년월일", columnDefinition = "DATE")
    @ApiModelProperty(example = "2000/01/03")
    private String birth;

    @Column(name = "이메일", columnDefinition = "VARCHAR(50)")
    @ApiModelProperty(example = "imdlsrks@gmail.com")
    private String email;
}
