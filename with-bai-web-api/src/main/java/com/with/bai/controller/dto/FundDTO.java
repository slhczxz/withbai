package com.with.bai.controller.dto;

import lombok.Data;

@Data
public class FundDTO {
    private Long fid;
    private String name;
    private Long code;
    private Double interestRate;
    private String risklevel;
    private Long baseline;
    private Double yearRate;
    private Integer investTime;
    private Long overallscope;
    private Long positions;
    private Integer power;
}
