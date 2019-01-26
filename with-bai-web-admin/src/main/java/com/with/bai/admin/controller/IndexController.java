package com.with.bai.admin.controller;

import com.with.bai.admin.service.IndexService;
import com.with.bai.dto.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="info")
public class IndexController {

    @Autowired
    IndexService indexService;

    @ModelAttribute
    public Info getInfo(HttpServletRequest request){

        Info info=indexService.getInfo();
        request.getSession().setAttribute("fundCount",info.getOrderCount());
        request.getSession().setAttribute("registCount",info.getRegistCount());
        return info;
    }
    @RequestMapping(value="index",method= RequestMethod.GET)
    public String index(){
        return "index";
    }
}
