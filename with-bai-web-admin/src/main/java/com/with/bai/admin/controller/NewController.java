package com.with.bai.admin.controller;

import com.with.bai.admin.service.ExpertService;
import com.with.bai.admin.service.NewService;
import com.with.bai.domain.Expert;
import com.with.bai.domain.Information;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value="information")
@Controller
public class NewController {

    @Autowired
    NewService newService;


    @RequestMapping(value="save",method = RequestMethod.POST)
    public String save(Information information, HttpServletRequest request, Model model){
        BaseResult baseResult=newService.save(information);
        model.addAttribute("baseResult",baseResult);
        return new_form();
    }
    @RequestMapping(value="new_form",method = RequestMethod.GET)
    public String new_form(){
        return "New_Form";
    }
}
