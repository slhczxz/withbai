package com.with.bai.controller;

import com.with.bai.controller.dto.HomePageDTO;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path.v1}/homePage")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    @RequestMapping(value = "getTotalLoan",method = RequestMethod.GET)
    private BaseResult getTotalLoan(){
        HomePageDTO homePageDTO=homePageService.getTotalLoan();
        BaseResult baseResult=BaseResult.showData(homePageDTO);
        return baseResult;
    }
}
