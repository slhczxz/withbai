package com.with.bai.service;

import com.with.bai.domain.Bank;
import com.with.bai.domain.Fund;
import com.with.bai.domain.Orders;
import com.with.bai.domain.User;

import java.util.List;

public interface PersonService {
     User personCenter(Long uid);

    List<Bank> getBank(Long uid);

    void addCard(Bank bank);

    List<Orders> myLoan(Long uid);

    List<Fund> myProduct(Long uid);

    void modify(User user);
}
