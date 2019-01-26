package com.with.bai.service;

import com.with.bai.controller.dto.LoanDTO;
import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;

public interface LoanPageService {

    BaseResult insertLoan(LoanDTO loanDTO);

    User selectUser(User user);
}
