package com.with.bai.dao;

import com.with.bai.controller.dto.LoanDTO;
import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanPageMapper {

    void insertLoan(LoanDTO loanDTO);

    User selectUser(User user);
}
