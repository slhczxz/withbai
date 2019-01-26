package com.with.bai.admin.dao;

import com.with.bai.domain.Fund;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductDao {
    Fund selectById(Long fid);

    int getCount(Fund fund);

    List<Fund> selectByPage(Map<String, Object> map);

    void deletemulti(String[] fids_arr);

    void deleteById(Long fid);

    Fund checkup(Fund fund);

    void insertFund(Fund fund);

    void insertLoan(Fund fund);

    void updateFund(Fund fund);

    void updateLoan(Fund fund);
}
