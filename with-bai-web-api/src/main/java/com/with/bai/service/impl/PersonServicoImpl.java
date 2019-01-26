package com.with.bai.service.impl;

import com.with.bai.dao.PersonCenterDao;
import com.with.bai.domain.Bank;
import com.with.bai.domain.Fund;
import com.with.bai.domain.Orders;
import com.with.bai.domain.User;
import com.with.bai.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServicoImpl implements PersonService {
    @Autowired
    PersonCenterDao personCenterDao;
    @Override
    public User personCenter(Long uid) {
        User user = personCenterDao.selectUserByUid(uid);
        return user;
    }

    @Override
    public List<Bank> getBank(Long uid) {
        List<Bank> bank = personCenterDao.selectBankByUid(uid);
       return bank;
    }

    @Override
    public void addCard(Bank bank) {
        personCenterDao.insertCard(bank);
    }

    @Override
    public List<Orders> myLoan(Long uid) {
        List<Orders> orders = personCenterDao.selectLoanByUid(uid);
        return orders;
    }

    @Override
    public List<Fund> myProduct(Long uid) {
        List<Fund> fund = personCenterDao.selectFund(uid);
        return fund;
    }

    @Override
    public void modify(User user) {
        personCenterDao.updateUser(user);
    }
}
