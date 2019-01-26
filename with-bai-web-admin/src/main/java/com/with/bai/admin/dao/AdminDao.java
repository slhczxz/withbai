package com.with.bai.admin.dao;

import com.with.bai.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    public Admin selectByName(String name);

}
