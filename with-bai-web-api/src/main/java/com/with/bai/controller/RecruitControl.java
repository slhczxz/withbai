package com.with.bai.controller;

import com.with.bai.domain.Recruit;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "recruit")
public class RecruitControl {
    @Autowired
    private RecruitService recruitService;

    @ResponseBody
    @RequestMapping(value = "category/{category}",method = RequestMethod.GET)
    public BaseResult getRecruitBycategory(@PathVariable("category") int category){
        Recruit recruit = recruitService.getRecruitBycategory(category);
        System.out.println(recruit);
        if(recruit!=null){
            BaseResult success = BaseResult.success("success", recruit);
            System.out.println(success);
            return success;
        }
        return BaseResult.fail();
    }

    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public BaseResult getRecruitAll(){
        List<Recruit> recruitAll = recruitService.getRecruitAll();
        if(recruitAll!=null){
            return BaseResult.success("获取成功",recruitAll);
        }else{
            return BaseResult.success("获取失败");
        }
    }
}
