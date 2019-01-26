package com.with.bai.admin.service;



import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;

public interface UserService {
    PageInfo getPageInfo(int draw, int start, int length, User tbUser);

    BaseResult save(User tbUser);

    BaseResult deletemulti(String uids);

    BaseResult deletebyId(Long uid);

    User selectUserById(Long uid);
}
