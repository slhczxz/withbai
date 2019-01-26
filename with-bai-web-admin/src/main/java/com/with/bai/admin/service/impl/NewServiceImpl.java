package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.NewDao;
import com.with.bai.admin.service.NewService;
import com.with.bai.domain.Information;
import com.with.bai.dto.BaseResult;
import com.with.bai.validator.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    NewDao newDao;
    @Override
    public BaseResult save(Information information) {
        String validator = BeanValidator.validator(information);
        if(validator == null){
            information.setTime(new Date());
            newDao.save(information);
            return BaseResult.success("保存成功");
        }
        return BaseResult.fail(validator);
    }
}
