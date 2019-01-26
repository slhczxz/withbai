package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.FundDao;
import com.with.bai.admin.dao.LoanDao;
import com.with.bai.admin.service.FundService;
import com.with.bai.domain.Fund;
import com.with.bai.domain.Orders;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import com.with.bai.utils.EmailUtil;
import com.with.bai.utils.EmailUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FundServiceImpl implements FundService {

    @Autowired
    FundDao fundDao;

    @Autowired
    EmailUtils emailUtils;

    @Override
    public PageInfo<Orders> getPageInfo(int draw, int start, int length, Orders orders) {
        PageInfo<Orders> pageInfo = new PageInfo<>();
        int count = fundDao.getCount(orders);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        map.put("orders",orders);
        //搜索条件是在tbUser内，把tbUser封装在map中
        if(orders!=null){
            if(orders.getFund()!=null){
                map.put("fundName", orders.getFund().getName());
            }
            if(orders.getUser()!=null) {
                map.put("userName", orders.getUser().getName());
            }
            if(orders.getFund()!=null){
                map.put("fundPower",orders.getFund().getPower());
            }
        }
        pageInfo.setData(fundDao.selectByPage(map));
        return pageInfo;
    }

    @Override
    public BaseResult approvemulti(String oids) {
        BaseResult baseResult=BaseResult.fail("审批失败");
        if(oids!=null){
            String[] oidArray=oids.split(",");
            fundDao.approvemulti(oidArray);
            baseResult=BaseResult.success("审批通过");
            List<Orders> orders=fundDao.getInfo(oidArray);
            for(Orders order:orders){
                EmailUtil email=new EmailUtil(order.getUser().getEmail(),String.format("尊敬的%s用户,您在本公司申请的---%s订单---,投资金额为%s人民币,已通过审核.感谢您的支持",
                        order.getUser().getName(),order.getFund().getName(),order.getLoanMoney()));
                email.run();
            }
         /*  if(orders.size()==1){
                Orders order=orders.get(0);
               EmailUtil email=new EmailUtil(order.getUser().getEmail(),String.format("尊敬的%s用户,您在本公司申请的---%s订单---,投资金额为%s人民币,已通过审核.感谢您的支持",
                       order.getUser().getName(),order.getFund().getName(),order.getLoanMoney()));
               email.run();
              *//*  email.("欢迎加入用呗",String.format("尊敬的%s用户,您在本公司申请的---%s订单---,投资金额为%s人民币,已通过审核.感谢您的支持",
                        order.getUser().getName(),order.getFund().getName(),order.getLoanMoney()),order.getUser().getEmail());*//*
            }else {
                String[] str = new String[orders.size()];
                for (int i = 0; i < orders.size(); i++) {
                    str[i] = orders.get(i).getUser().getEmail();
                }
                emailUtils.send("欢迎加入用呗", "尊敬的用户,您在本公司申请的---订单---,已通过审核", str);
            }*/
        }
        return baseResult;
    }
}
