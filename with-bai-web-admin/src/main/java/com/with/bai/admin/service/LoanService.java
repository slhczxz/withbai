package com.with.bai.admin.service;

import com.with.bai.domain.Orders;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import org.springframework.core.annotation.Order;

public interface LoanService {
    PageInfo<Orders> getPageInfo(int draw, int start, int length, Orders order);

    BaseResult approvemulti(String oids);
}
