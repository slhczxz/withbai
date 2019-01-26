package com.with.bai.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Help implements Serializable {
    /**
     * 	hid,
     * 	category,
     * 	question,
     * 	answer
     */
    private String hid;
    private String category;
    private String question;
    private String answer;

}