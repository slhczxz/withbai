package com.with.bai.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {

    private  Long oid;
    private  Double loanMoney;
    private Date startTime;
    private  Date endTime;
    private String state;
    private Long uid;
    private Long lid;
    private Long fid;
    private User user;
    private Loan loan;
    private Fund fund;




}
