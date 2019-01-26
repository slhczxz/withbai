package com.with.bai.dao;

import com.with.bai.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageMapper {

    List<Orders> getTotalLoan();

    Orders getFirstLoan();

}
