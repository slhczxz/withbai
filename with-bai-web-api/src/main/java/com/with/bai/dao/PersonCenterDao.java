package com.with.bai.dao;

import com.with.bai.domain.Bank;
import com.with.bai.domain.Fund;
import com.with.bai.domain.Orders;
import com.with.bai.domain.User;

import java.util.List;

public interface PersonCenterDao {
    User selectUserByUid(Long uid);

    List<Bank> selectBankByUid(Long uid);

    void insertCard(Bank bank);

    List<Orders> selectLoanByUid(Long uid);

    List<Fund> selectFund(Long uid);

    void updateUser(User user);

    int getCounts();

}
