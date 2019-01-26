package com.with.bai.admin.controller;

import com.with.bai.domain.Admin;
import com.with.bai.dto.BaseResult;
import com.with.bai.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, Admin admin, HttpServletRequest request, HttpServletResponse response) {
        //实现登录
        BaseResult baseResult = adminService.getResult(admin);
        if (baseResult.getStatus() == 500) {
            //登录失败
            model.addAttribute("baseResult", baseResult);
            return login();

        } else{
            //登录成功
            request.getSession().setAttribute("admin",admin);
            return "redirect:/info/index";
        }

    }


    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping(value="logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }


}
