package com.with.bai.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class Admin {


    private Long aid;
    @Length(min=1,message="用户名不能为空")
    private String name;
    private String email;
    @Length(min=1,message = "密码不能为空")
    private String password;


}
