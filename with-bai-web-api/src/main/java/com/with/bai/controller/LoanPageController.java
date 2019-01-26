package com.with.bai.controller;

import com.with.bai.controller.dto.LoanDTO;
import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.LoanPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${api.path.v1}/loanPage")
public class LoanPageController {

    @Autowired
    private LoanPageService loanPageService;

    @RequestMapping(value = "insertLoan",method = RequestMethod.GET)
    private BaseResult insertLoan(LoanDTO loanDTO, HttpServletRequest request){
        //User user=loanPageService.selectUser((User)request.getSession().getAttribute("user"));


        //loanDTO.setUid(user.getUid());
        //LoanDTO loanDTO=new LoanDTO();
        loanDTO.setUid(2L);
        //loanDTO.setLoanMoney(loanMoney);
        //System.out.println("2222221-------->"+loanMoney);
        System.out.println("111111111-------->"+loanDTO);
        BaseResult baseResult=loanPageService.insertLoan(loanDTO);
        return baseResult;
    }

}
