package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.IndexDao;
import com.with.bai.admin.service.IndexService;
import com.with.bai.dto.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexDao indexDao;
    @Override
    public Info getInfo() {
        Info info=new Info();
        info.setOrderCount(indexDao.orderCount());
        info.setRegistCount(indexDao.registCount());
        return info;
    }
}
