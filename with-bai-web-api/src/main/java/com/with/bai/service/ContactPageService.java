package com.with.bai.service;

import com.with.bai.controller.dto.ContactPageDTO;
import com.with.bai.dto.BaseResult;

public interface ContactPageService {
    BaseResult insertOpinion(ContactPageDTO contactPageDTO);
}
