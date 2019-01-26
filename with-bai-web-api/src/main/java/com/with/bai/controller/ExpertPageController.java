package com.with.bai.controller;

import com.with.bai.dto.BaseResult;
import com.with.bai.service.ExpertPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path.v1}/expertPage")
public class ExpertPageController {

    @Autowired
    private ExpertPageService expertPageService;

    @RequestMapping(value = "getExpert",method = RequestMethod.GET)
    private BaseResult getExpert(){
        BaseResult baseResult=expertPageService.getExpert();
        return baseResult;
    }


}
