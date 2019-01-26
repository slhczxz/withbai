package com.with.bai.service.impl;

import com.with.bai.controller.dto.ContactPageDTO;
import com.with.bai.dao.ContactPageMapper;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.ContactPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactPageServiceImpl implements ContactPageService {

    @Autowired
    private ContactPageMapper contactPageMapper;

    @Override
    public BaseResult insertOpinion(ContactPageDTO contactPageDTO) {
        contactPageMapper.insertOpinion(contactPageDTO);
        BaseResult baseResult = BaseResult.success("提交成功",contactPageDTO);
        return baseResult;
    }
}
