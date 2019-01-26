package com.with.bai.controller;

import com.with.bai.controller.dto.UserDTO;
import com.with.bai.domain.Bank;
import com.with.bai.domain.Fund;
import com.with.bai.domain.Orders;
import com.with.bai.domain.User;
import com.with.bai.dto.BaseResult;
import com.with.bai.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "${api.path.v1}")
public class PersonController {
    @Autowired
    PersonService personService;

    private BaseResult baseResult;

    /*个人信息查看*/
    @CrossOrigin
    @RequestMapping(value = "person_center",method = RequestMethod.GET)
    public BaseResult personCenter(HttpServletRequest request){
        User user1=(User) request.getSession().getAttribute("user");
        if(user1 == null){
            baseResult = BaseResult.fail("false");
        }else{


        Long uid = user1.getUid();
//        Long uid = 1L;
        UserDTO userDTO = new UserDTO();
        User user = personService.personCenter(uid);
        List<Bank> bank = personService.getBank(uid);
        if(bank == null){
            userDTO.setBank(null);
        }
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setIDNumber(user.getIDNumber());
        userDTO.setPhone(user.getPhone());
        userDTO.setBank(bank);
       /* userDTO.setBname(bank.getName());
        userDTO.setCardNumber(bank.getCardNumber());*/
        //BaseResult baseResult=null;
            baseResult = BaseResult.showData(userDTO);
        }
        return baseResult;


    }

    /*添加银行卡*/
    @CrossOrigin
    @RequestMapping(value = "addcard",method = RequestMethod.GET)
    public BaseResult addCard(Bank bank,HttpServletRequest request){
         baseResult = BaseResult.success("true");
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            baseResult = BaseResult.fail("false");
        }
        Long uid = user.getUid();
//        Long uid = 1L;
        bank.setUid(uid);
        personService.addCard(bank);
        return baseResult;
    }
    /*我的贷款项目*/
    @CrossOrigin
    @RequestMapping(value = "myloan",method = RequestMethod.GET)
    public BaseResult myLoan(HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            baseResult = BaseResult.fail("false");
        }
        Long uid = user.getUid();
        List<Orders> orders = personService.myLoan(uid);
        baseResult = BaseResult.showData(orders);
        return baseResult;
    }
    /*我购买的理财产品*/
    @CrossOrigin
    @RequestMapping(value = "myproduct",method = RequestMethod.GET)
    public BaseResult myProduct(HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            baseResult = BaseResult.fail("false");
        }
        Long uid = user.getUid();
       List<Fund> fund = personService.myProduct(uid);
       baseResult = BaseResult.showData(fund);
        return baseResult;

    }
    /*修改信息*/
    @CrossOrigin
    @RequestMapping(value = "modify",method = RequestMethod.GET)
    public BaseResult Modify(User user,HttpServletRequest request){
        User user1 = (User) request.getSession().getAttribute("user");
        if(user1 == null){
            baseResult = BaseResult.fail("false");
        }else{
            Long uid = user1.getUid();
            user.setUid(uid);
            baseResult = BaseResult.success("true");
        }
        return baseResult;

    }
}
