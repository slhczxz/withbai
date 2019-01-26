package com.with.bai.service;


import com.with.bai.dto.BaseResult;

public interface InformationService {

    BaseResult getInformation();

    BaseResult getInformationById(Long iid);
}
