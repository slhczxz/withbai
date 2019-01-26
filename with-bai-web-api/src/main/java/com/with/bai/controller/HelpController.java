package com.with.bai.controller;

import com.with.bai.dto.BaseResult;
import com.with.bai.service.HelpService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/helps")
public class HelpController {

    @Autowired
    private HelpService helpService;

    @RequestMapping(value = "{category}",method= RequestMethod.GET)
    public BaseResult selectBycategory(@PathVariable String category){
        BaseResult baseResult =helpService.selectBycategory(category);
        return baseResult;
    }

}
