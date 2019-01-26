package com.with.bai.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Loan {
    private Long lid;
    @NotNull
    private String name;
    @NotNull
    private Long amount;
    @NotNull
    private Long cost;
    @NotNull
    private Double ltvRatio;
}
