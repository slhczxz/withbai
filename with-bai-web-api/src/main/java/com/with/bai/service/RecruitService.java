package com.with.bai.service;

import com.with.bai.domain.Recruit;

import java.util.List;

public interface RecruitService {
    public Recruit getRecruitBycategory(int category);

    public List<Recruit> getRecruitAll();
}
