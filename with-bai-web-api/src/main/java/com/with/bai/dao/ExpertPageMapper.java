package com.with.bai.dao;

import com.with.bai.domain.Expert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertPageMapper {

    List<Expert> getExpert();
}
