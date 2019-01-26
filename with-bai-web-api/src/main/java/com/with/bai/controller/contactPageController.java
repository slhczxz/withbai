package com.with.bai.controller;

import com.with.bai.controller.dto.ContactPageDTO;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.ContactPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path.v1}/contactPage")
public class contactPageController {

    @Autowired
    private ContactPageService contactPageService;

    @RequestMapping(value = "insertOpinion",method = RequestMethod.GET)
    private BaseResult insertOpinion(ContactPageDTO contactPageDTO){
        BaseResult baseResult=contactPageService.insertOpinion(contactPageDTO);
        return baseResult;
    }
}
