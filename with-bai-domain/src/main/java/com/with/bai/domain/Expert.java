package com.with.bai.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class Expert {
    private Long eid;
    @Length(min=1,message="名字不能为空")
    private String name;
    @Length(min=1,message="图片不能为空")
    private String image;
    @Length(min=1,message="详情不能为空")
    private String detail;
}
