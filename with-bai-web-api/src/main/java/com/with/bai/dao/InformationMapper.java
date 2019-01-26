package com.with.bai.dao;

import com.with.bai.domain.Information;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationMapper {

    List<Information> getInformation();

    Information getInformationById(Long iid);
}
