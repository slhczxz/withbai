package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.AdminDao;
import com.with.bai.domain.Admin;
import com.with.bai.dto.BaseResult;
import com.with.bai.admin.service.AdminService;
import com.with.bai.validator.BeanValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Override
    public BaseResult getResult(Admin admin) {
        String message = BeanValidator.validator(admin);
        if (message == null) {
            Admin admin1 = adminDao.selectByName(admin.getName());
            if (admin1 != null) {
                if (admin1.getPassword().equals(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()))) {
                    return BaseResult.success("登录成功", admin1);
                }
            }
            return BaseResult.fail("用户名或者密码错误");
        }
        return BaseResult.fail(message);
    }

}
