package com.with.bai.service.impl;

import com.with.bai.controller.dto.HomePageDTO;
import com.with.bai.dao.HomePageMapper;
import com.with.bai.domain.Orders;
import com.with.bai.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageMapper homePageMapper;

    @Override
    public HomePageDTO getTotalLoan() {

        HomePageDTO homePageDTO=new HomePageDTO();
       List<Orders> orders=homePageMapper.getTotalLoan();
        Orders orders1=homePageMapper.getFirstLoan();
        int totalNumber=0;
        Double totalMoney=0.0;
        for(Orders o:orders){
            totalMoney+=o.getLoanMoney();
            totalNumber++;
        }
        Date date=new Date();
        Long daysBetween = cTime(orders1.getStartTime(), date);
        System.out.println(orders1.getStartTime());
        System.out.println(new Date());
        homePageDTO.setMoney(totalMoney);
        homePageDTO.setDeal(totalNumber);
        homePageDTO.setDay(daysBetween);
        return homePageDTO;
    }
    private static Long cTime(Date date1,Date date2){

        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        Date d1=sdf.parse(date1);

        Date d2=sdf.parse(date2);*/

        long daysBetween=(date2.getTime()-date1.getTime()+1000000)/(60*60*24*1000);

        return daysBetween;
    }
}
