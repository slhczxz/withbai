package com.with.bai.service.impl;

import com.with.bai.dao.HelpDao;
import com.with.bai.domain.Help;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpServiceImpl implements HelpService {
    @Autowired
    private HelpDao helpdao;

    @Override
    public BaseResult selectBycategory(String category) {
        List<Help> helps = helpdao.selectBycategory(category);
        BaseResult baseResult=null;
        if(helps!=null){
            baseResult=BaseResult.success(200,"成功",helps);

    }else {
        BaseResult.fail(500,"失败");
        }
        return  baseResult;
    }
}
