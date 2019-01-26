package com.with.bai.admin.controller;

import com.with.bai.domain.Fund;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import com.with.bai.admin.service.ProductService;
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
@RequestMapping(value="content")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute
    public Fund selectById(Long fid){
        Fund fund=new Fund();
        if(fid!=null){
            fund=productService.selectById(fid);
        }
        return fund;
    }

    @RequestMapping(value="form",method= RequestMethod.GET)
    public String form(){
        return "content_form";
    }

    @RequestMapping(value="detail",method= RequestMethod.GET)
    public String detail(Fund fund){
        if(fund.getPower()==0){
            return "ftable";
        }else{
            return "ltable";
        }
    }

    @ResponseBody
    @RequestMapping(value="page",method= RequestMethod.GET)
    public PageInfo<Fund> page(HttpServletRequest request, Fund fund){
        String str_Draw=request.getParameter("draw");
        String str_Length=request.getParameter("length");
        String str_start=request.getParameter("start");
        int draw=str_Draw==null?1:Integer.parseInt(str_Draw);
        int length=str_Length==null?10:Integer.parseInt(str_Length);
        int start=str_start==null?0:Integer.parseInt(str_start);
        return productService.getPageInfo(draw,length,start,fund);
    }

    @RequestMapping(value="content_list",method= RequestMethod.GET)
    public String list(){
        return "content_list";
    }

    @RequestMapping(value="save",method = RequestMethod.POST)
    public String save(Fund fund, RedirectAttributes redirectAttributes, Model model){
        BaseResult baseResult = productService.save(fund);
        if(baseResult.getStatus()== BaseResult.STATUS_SUCCESS){
            //如果表单验证通过了,把封装了具体状态码和信息的baseResult对象转递到目标页面
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/content_list";
        }
        else{
            model.addAttribute("baseResult",baseResult);
            model.addAttribute("fund",fund);
            return "content_form";
        }
    }

    @ResponseBody
    @RequestMapping(value="deletemulti",method = RequestMethod.GET)
    public BaseResult deletemulti(String fids){
        BaseResult baseResult = productService.deletemulti(fids);
        return baseResult;
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method= RequestMethod.GET)
    public BaseResult deleteById(Long fid, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = productService.deleteById(fid);
        return baseResult;
    }

}
