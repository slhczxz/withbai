package com.with.bai.domain;

import lombok.Data;

@Data
public class Opinion {
    private Long oid;
    private String uname;
    private String uemail;
    private String details;
    private Long uid;

}
