package com.with.bai.service.impl;

import com.with.bai.controller.dto.LoanDTO;
import com.with.bai.dao.LoanPageMapper;
import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.LoanPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanPageServiceImpl implements LoanPageService {

    @Autowired
    private LoanPageMapper loanPageMapper;

    @Override
    public BaseResult insertLoan(LoanDTO loanDTO) {
        BaseResult baseResult=null;
        if(loanDTO.getUid()!=null){
            loanPageMapper.insertLoan(loanDTO);
            baseResult=BaseResult.success("申请成功");
        }else {
            baseResult=BaseResult.fail("请先登录");
        }
        return baseResult;
    }

    @Override
    public User selectUser(User user) {
        User user1 = loanPageMapper.selectUser(user);
        if (user1!=null){
            return user1;
        }
        return null;
    }
}
