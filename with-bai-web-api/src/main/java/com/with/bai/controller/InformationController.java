package com.with.bai.controller;

import com.with.bai.dto.BaseResult;
import com.with.bai.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path.v1}/information")
public class InformationController {


    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "getInformation",method = RequestMethod.GET)
    private BaseResult getInformation(){
        BaseResult baseResult=informationService.getInformation();
        return baseResult;
    }

    @RequestMapping(value = "getInformationById",method = RequestMethod.GET)
    private BaseResult getInformationById(Long iid){
        BaseResult baseResult=informationService.getInformationById(iid);
        return baseResult;
    }

}
