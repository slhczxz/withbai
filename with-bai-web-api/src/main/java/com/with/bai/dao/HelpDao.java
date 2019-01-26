package com.with.bai.dao;

import com.with.bai.domain.Help;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HelpDao {
   List<Help> selectBycategory(String category);
}
