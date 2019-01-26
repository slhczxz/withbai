package com.with.bai.admin.controller;

import com.with.bai.admin.service.ExpertService;
import com.with.bai.domain.Expert;
import com.with.bai.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="expert")
public class ExpertController {

    @Autowired
    ExpertService expertService;

    @RequestMapping(value="save",method = RequestMethod.POST)
    public String save(Expert expert, HttpServletRequest request, Model model){
        BaseResult baseResult=expertService.save(expert);
        model.addAttribute("baseResult",baseResult);
        return expert_form();
    }
    @RequestMapping(value="expert_form",method = RequestMethod.GET)
    public String expert_form(){
        return "expert";
    }
}
