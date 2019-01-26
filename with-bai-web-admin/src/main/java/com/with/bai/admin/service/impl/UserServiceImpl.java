package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.UserDao;
import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import com.with.bai.admin.service.UserService;
import com.with.bai.validator.BeanValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public PageInfo<User> getPageInfo(int draw, int start, int length, User user) {
        PageInfo<User> pageInfo = new PageInfo<>();
        int count = userDao.getCount(user);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        //搜索条件是在tbUser内，把tbUser封装在map中
        map.put("user",user);
        pageInfo.setData(userDao.selectByPage(map));
        return pageInfo;
    }


    @Override
    public BaseResult save(User user) {
        String message= BeanValidator.validator(user);
        BaseResult baseResult=null;
        if(message==null){
            //新增用户
            if(user.getUid()==null){
                if(!checkup(user)){
                    return BaseResult.fail("有字段已存在,请谨慎填写");
                }
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                user.setCreated(new Date());
                user.setUpdated(new Date());
                userDao.insert(user);
            }
            else{
                user.setUpdated(new Date());
                userDao.update(user);
            }
            baseResult= BaseResult.success("保存用户成功");
        }else{
            baseResult= BaseResult.fail(message);
        }

        return baseResult;
    }

    public boolean checkup(User user){
        int count=userDao.checkup(user);
        if(count>0){
            return false;
        }
        return true;
    }

    @Override
    public BaseResult deletemulti(String uids) {

        if(StringUtils.isNotBlank(uids)) {
            String[] uids_array = uids.split(",");
            userDao.deletemulti(uids_array);
            return BaseResult.success("删除成功");
        }else{
            return BaseResult.fail("删除失败");
        }
    }

    @Override
    public BaseResult deletebyId(Long uid) {
        if(uid!=null){
            userDao.deleteById(uid);
            return BaseResult.success("删除成功");
        }else{
            return BaseResult.fail("删除失败");
        }
    }

    @Override
    public User selectUserById(Long uid) {
        ;
        return userDao.selectById(uid);
    }

}
