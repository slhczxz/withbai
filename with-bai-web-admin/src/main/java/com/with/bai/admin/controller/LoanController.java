package com.with.bai.admin.controller;

import com.with.bai.admin.service.LoanService;
import com.with.bai.domain.Orders;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @ResponseBody
    @RequestMapping(value="page",method= RequestMethod.GET)
    public PageInfo<Orders> page(HttpServletRequest request, Orders order){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        int draw=strDraw==null?1:Integer.parseInt(strDraw);
        int start=strStart==null?0:Integer.parseInt(strStart);
        int length=strLength==null?10:Integer.parseInt(strLength);
        PageInfo<Orders> pageInfo=loanService.getPageInfo(draw,start,length,order);
        return pageInfo;
    }

    @RequestMapping(value="loan_list",method = RequestMethod.GET)
    public String loanlist(){
        return "loan_list";
    }

    @ResponseBody
    @RequestMapping(value="approvemulti",method=RequestMethod.GET)
    public BaseResult approvemulti(String oids){

        return loanService.approvemulti(oids);
    }

}
