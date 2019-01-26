package com.with.bai.admin.controller;

import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import com.with.bai.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;


    //自动将javabean翻译成json
    @ResponseBody
    @RequestMapping(value="deletemulti",method= RequestMethod.GET)
    public BaseResult deletemulti(String uids){
        BaseResult baseResult=userService.deletemulti(uids);
        return baseResult;
    }

    @ResponseBody
    @RequestMapping(value="deletebyId",method= RequestMethod.GET)
    public BaseResult deletebyId(Long uid){

        return userService.deletebyId(uid);
    }

    @RequestMapping(value="list",method = RequestMethod.GET)
    public String list(Model model){
        return "user_list";
    }


    @ModelAttribute("tbUser")
    public User getUser(Long uid){
        User tbUser = new User();
        if(uid!=null){
            tbUser =  userService.selectUserById(uid);
        }
        return tbUser;
    }

    @RequestMapping(value="show",method= RequestMethod.GET)
    public String show(){
        return "show";
    }

    @RequestMapping(value="form",method = RequestMethod.GET)
    public String form(){

        return "user_form";
    }


    @RequestMapping(value="save",method = RequestMethod.POST)
    public String save(User user, RedirectAttributes redirectAttributes, Model model){
        BaseResult baseResult = userService.save(user);
        if(baseResult.getStatus()== BaseResult.STATUS_SUCCESS){
            //如果表单验证通过了,把封装了具体状态码和信息的baseResult对象转递到目标页面
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        else{
            //如果表单验证没有通过
            //返回错误信息，并且回到新增页面
            model.addAttribute("baseResult",baseResult);
            model.addAttribute("tbUser",user);
            return "user_form";
        }
    }

    @ResponseBody
    @RequestMapping(value="page",method= RequestMethod.GET)
    public PageInfo<User> page(HttpServletRequest request, User user){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        int draw=strDraw==null?1:Integer.parseInt(strDraw);
        int start=strStart==null?0:Integer.parseInt(strStart);
        int length=strLength==null?10:Integer.parseInt(strLength);
        PageInfo<User> pageInfo=userService.getPageInfo(draw,start,length,user);
        System.out.println(user.getEmail());
        return pageInfo;
    }
}
