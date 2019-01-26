package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.LoanDao;
import com.with.bai.admin.service.LoanService;
import com.with.bai.domain.Orders;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanDao loanDao;

    @Override
    public PageInfo<Orders> getPageInfo(int draw, int start, int length, Orders orders) {
        PageInfo<Orders> pageInfo = new PageInfo<>();
        int count = loanDao.getCount(orders);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        map.put("orders",orders);
        if(orders!=null){
            if(orders.getUser()!=null) {
                map.put("userName", orders.getUser().getName());
            }
            if(orders.getLoan()!=null){
                map.put("loanName",orders.getLoan().getName());
            }
        }
        pageInfo.setData(loanDao.selectByPage(map));
        return pageInfo;
    }

    @Override
    public BaseResult approvemulti(String oids) {
        BaseResult baseResult=BaseResult.fail("审批失败");
        if(oids!=null){
            String[] oidArray=oids.split(",");
            loanDao.approvemulti(oidArray);
            baseResult=BaseResult.success("审批通过");
        }
        return baseResult;
    }
}
