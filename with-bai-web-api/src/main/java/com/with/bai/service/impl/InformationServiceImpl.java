package com.with.bai.service.impl;

import com.with.bai.dao.InformationMapper;
import com.with.bai.domain.Information;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;


    @Override
    public BaseResult getInformation() {

        List<Information> information=informationMapper.getInformation();

        BaseResult baseResult = BaseResult.success("显示成功！", information);
        return baseResult;
    }

    @Override
    public BaseResult getInformationById(Long iid) {
        Information information=informationMapper.getInformationById(iid);

        BaseResult baseResult = BaseResult.success("显示成功！", information);
        return baseResult;
    }
}
