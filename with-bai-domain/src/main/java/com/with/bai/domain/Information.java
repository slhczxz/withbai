package com.with.bai.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class Information {
    private Long iid;
    @Length(min=1,message="标题不能为空")
    private String title;
    private Date time;
    @Length(min=1,message="图片不能为空")
    private String image;
    @Length(min=1,message="内容不能为空")
    private String content;

}
