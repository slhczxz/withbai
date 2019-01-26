package com.with.bai.service.impl;

import com.with.bai.dao.RecruitDao;
import com.with.bai.domain.Recruit;
import com.with.bai.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceimpl implements RecruitService {
    @Autowired
    private RecruitDao recruitDao;

    @Override
    public Recruit getRecruitBycategory(int category) {
        Recruit recruit = recruitDao.getRecruitBycategory(category);
        return recruit;
    }

    @Override
    public List<Recruit> getRecruitAll() {
        List<Recruit> recruits = recruitDao.getRecruitAll();
        return recruits;
    }
}
