package com.with.bai.controller.dto;

import com.with.bai.domain.Bank;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String email;
    private String name;
    private String IDNumber;
    private String phone;

    private List<Bank> bank;

}
