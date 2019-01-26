package com.with.bai.admin.dao;


import com.with.bai.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    int checkup(User user);

    User selectById(Long uid);

    void insert(User tbUser);

    void deleteById(Long uid);

    void update(User tbUser);

    void deletemulti(String[] uids_array);

    int getCount(User tbUser);

    List<User> selectByPage(Map<String, Object> map);
}
