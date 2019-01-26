package com.with.bai.admin.dao;

import com.with.bai.domain.Expert;
import com.with.bai.dto.BaseResult;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertDao {
    void save(Expert expert);
}
