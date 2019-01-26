package com.with.bai.admin.service;

import com.with.bai.domain.Fund;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;

public interface ProductService {
    Fund selectById(Long fid);

    PageInfo<Fund> getPageInfo(int draw, int length, int start, Fund fund);

    BaseResult save(Fund fund);

    BaseResult deletemulti(String fids);

    BaseResult deleteById(Long fid);
}
