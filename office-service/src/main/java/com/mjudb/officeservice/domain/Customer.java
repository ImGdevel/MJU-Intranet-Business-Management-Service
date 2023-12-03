package com.mjudb.officeservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "발주처")
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="발주처번호", columnDefinition = "NUMBER(5,0)")
    @ApiModelProperty(example = "12345")
    private Long cust_num;

    @Column(name = "발주처이름", columnDefinition = "VARCHAR(50)")
    @ApiModelProperty(example = "ABC Company")
    private String cust_name;

    @Column(name = "발주처전화번호", columnDefinition = "VARCHAR(20)")
    @ApiModelProperty(example = "031)1234-5678")
    private String cust_phone_num;

    @Column(name = "발주처이메일", columnDefinition = "VARCHAR(50)")
    @ApiModelProperty(example = "imdinrks@gmail.com")
    private String cust_email;

}
