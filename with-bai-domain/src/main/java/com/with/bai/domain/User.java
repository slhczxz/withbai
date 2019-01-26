package com.with.bai.domain;

import com.with.bai.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class User {

    private Long uid;
    @Pattern(regexp = RegexpUtils.EMAIL,message="邮箱格式不正确")
    private String email;
    @Length(min=1,message = "用户名不能为空")
    private String name;
    @Length(min=1,message="密码不能为空")
    private String password;
    @Pattern(regexp = RegexpUtils.IDNUMBER,message="身份证号格式不正确")
    private String IDNumber;
    @Pattern(regexp = RegexpUtils.PHONE,message = "手机号格式不正确")
    private String phone;
    private String sex;
    private String job;
    private Date created;
    private Date updated;
    private int record;
    private int assets;
    private int employment;

}
