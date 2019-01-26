package com.with.bai.service.impl;

import com.with.bai.dao.ExpertPageMapper;
import com.with.bai.domain.Expert;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.ExpertPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertPageServiceImpl implements ExpertPageService {

    @Autowired
    private ExpertPageMapper expertPageMapper;


    @Override
    public BaseResult getExpert() {
        List<Expert> experts=expertPageMapper.getExpert();
        BaseResult baseResult = BaseResult.success("显示成功！", experts);
        return baseResult;
    }
}
