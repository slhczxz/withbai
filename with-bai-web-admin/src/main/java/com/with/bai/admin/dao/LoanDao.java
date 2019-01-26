package com.with.bai.admin.dao;

import com.with.bai.domain.Orders;
import com.with.bai.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LoanDao {
    int getCount(Orders orders);

    List<Orders> selectByPage(Map<String, Object> map);

    void approvemulti(String[] oidArray);
}
