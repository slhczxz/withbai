package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.ExpertDao;
import com.with.bai.admin.service.ExpertService;
import com.with.bai.domain.Expert;
import com.with.bai.dto.BaseResult;
import com.with.bai.validator.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    ExpertDao expertDao;
    @Override
    public BaseResult save(Expert expert) {
        String validator = BeanValidator.validator(expert);
        if(validator == null){
           expertDao.save(expert);
           return BaseResult.success("保存成功");
        }
        return BaseResult.fail(validator);
    }
}
