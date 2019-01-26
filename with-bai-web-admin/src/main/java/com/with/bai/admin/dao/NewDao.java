package com.with.bai.admin.dao;

import com.with.bai.domain.Information;
import org.springframework.stereotype.Repository;

@Repository
public interface NewDao {
    void save(Information information);
}
