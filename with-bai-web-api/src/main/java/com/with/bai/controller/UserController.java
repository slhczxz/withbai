package com.with.bai.controller;


import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public User getUser(User user){

        return user;
    }

    /*
    注册
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "adduser",method = RequestMethod.POST)
    public BaseResult addUser(User user, HttpServletRequest request){
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        boolean flag=userService.addUser(user);
        if(flag){
            return BaseResult.success("true");
        }else{
            return BaseResult.fail("false");
        }

    }
}
