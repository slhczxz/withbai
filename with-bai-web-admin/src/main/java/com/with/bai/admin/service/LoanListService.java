package com.with.bai.admin.service;

import com.with.bai.domain.Fund;
import com.with.bai.domain.Loan;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;

public interface LoanListService {
    Loan selectById(Long lid);

    PageInfo<Loan> getPageInfo(int draw, int start, int length, Loan loan);

    BaseResult save(Loan loan);

    BaseResult deletemulti(String lids);

    BaseResult deleteById(Long lid);
}
