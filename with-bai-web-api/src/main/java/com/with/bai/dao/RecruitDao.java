package com.with.bai.dao;

import com.with.bai.domain.Recruit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitDao {
    public Recruit getRecruitBycategory(int category);

    public List<Recruit> getRecruitAll();
}
