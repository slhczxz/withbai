package com.with.bai.dao;

import com.with.bai.controller.dto.ContactPageDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPageMapper {

    void insertOpinion(ContactPageDTO contactPageDTO);
}
