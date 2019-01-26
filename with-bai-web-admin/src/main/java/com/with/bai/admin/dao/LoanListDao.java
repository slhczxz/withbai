package com.with.bai.admin.dao;

import com.with.bai.domain.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LoanListDao {
    List<Loan> selectByPage(Map<String, Object> map) ;

    int getCount(Loan loan);

    Loan selectById(Long lid);

    void insert(Loan loan);

    void update(Loan loan);

    Loan checkup(Loan loan);

    void deletemulti(String[] lids_arr);

    void deleteById(Long lid);
}
