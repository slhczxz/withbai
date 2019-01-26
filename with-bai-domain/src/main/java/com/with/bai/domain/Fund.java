package com.with.bai.domain;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Fund {

    private Long    fid;
    @Length(min = 4,message = "最少为6个字符")
    private String  name;
    private String  fullname;
    private Long    code;
    private String  risklevel;
    private Integer state;
    private Date    opentradingdate;
    private String  company;
    private String    dateofestablishment;
    private Double  interestRate;
    private String  generalmanager;
    @NotNull
    private Long    overallscope;
    private Double  totalassets;
    private Double  dateUpLow;
    private Long    baseline;
    private Double  yearRate;
    private Integer investTime;
    private String    remainingtime;
    @NotNull
    private Double  unitPrice;
    private Long    positions;
    private String  introduction;
    @NotNull
    private Integer power;

}
