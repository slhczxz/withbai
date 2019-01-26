package com.with.bai.controller;

import com.with.bai.domain.Fund;
import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${api.path.v1}/funds")
public class FundController {

    @Autowired
    private FundService service;

    @RequestMapping(value = "category/{power}", method = RequestMethod.GET)
    public BaseResult category(@PathVariable("power") int power) {
        return service.selectFundByPower(power);
    }

    @RequestMapping(value = "fund/{fid}", method = RequestMethod.GET)
    public BaseResult fund(@PathVariable("fid") Long fid) {
        return service.selectFundByFid(fid);
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public BaseResult page( String page, String limit, Fund fund) {
        int spage = page == null ? 1 : Integer.parseInt(page);
        int slimit = limit == null ? 10 : Integer.parseInt(limit);
        BaseResult baseResult = service.selectFundByPages(spage, slimit, fund);
        return baseResult;
    }

    @RequestMapping(value = "pay", method = RequestMethod.POST)
    public BaseResult pay(Long fid, Double money, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return service.payByFund(fid, user, money);
    }

    @RequestMapping(value = "information",method = RequestMethod.GET)
    public BaseResult information(){
        return service.getInformation();
    }



}

