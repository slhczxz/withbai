package com.with.bai.admin.controller;

import com.with.bai.admin.service.LoanListService;
import com.with.bai.domain.Fund;
import com.with.bai.domain.Loan;
import com.with.bai.domain.Orders;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
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
@RequestMapping(value="loanlist")
public class LoanListController {

    @Autowired
    LoanListService loanListService;

    @ModelAttribute
    public Loan selectById(Long lid){
        Loan loan=new Loan();
        if(lid!=null){
            loan=loanListService.selectById(lid);
        }
        return loan;
    }

    @RequestMapping(value="form",method= RequestMethod.GET)
    public String form(){
        return "loan_form";
    }

    @RequestMapping(value="detail",method= RequestMethod.GET)
    public String detail(Loan loan){
        return "table";
    }

    @ResponseBody
    @RequestMapping(value="page",method= RequestMethod.GET)
    public PageInfo<Loan> page(HttpServletRequest request,Loan loan){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        int draw=strDraw==null?1:Integer.parseInt(strDraw);
        int start=strStart==null?0:Integer.parseInt(strStart);
        int length=strLength==null?10:Integer.parseInt(strLength);
        PageInfo<Loan> pageInfo=loanListService.getPageInfo(draw,start,length,loan);
        return pageInfo;
    }

    @RequestMapping(value="loan_list",method= RequestMethod.GET)
    public String list(){
        return "loan_content";
    }

    @RequestMapping(value="save",method = RequestMethod.POST)
    public String save(Loan loan, RedirectAttributes redirectAttributes, Model model){
        BaseResult baseResult = loanListService.save(loan);
        if(baseResult.getStatus()== BaseResult.STATUS_SUCCESS){
            //如果表单验证通过了,把封装了具体状态码和信息的baseResult对象转递到目标页面
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/loanlist/loan_list";
        }
        else{
            model.addAttribute("baseResult",baseResult);
            model.addAttribute("loan",loan);
            return "loan_form";
        }
    }
    @ResponseBody
    @RequestMapping(value="deletemulti",method = RequestMethod.GET)
    public BaseResult deletemulti(String lids){
        BaseResult baseResult = loanListService.deletemulti(lids);
        return baseResult;
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method= RequestMethod.GET)
    public BaseResult deleteById(Long lid, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = loanListService.deleteById(lid);
        return baseResult;
    }
}
