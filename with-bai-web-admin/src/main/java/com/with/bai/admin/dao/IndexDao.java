package com.with.bai.admin.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IndexDao {

    int orderCount();
    int registCount();
}
