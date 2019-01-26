package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.ProductDao;
import com.with.bai.domain.Fund;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import com.with.bai.admin.service.ProductService;
import com.with.bai.validator.BeanValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    private Double mul;

    @Override
    public Fund selectById(Long fid) {
        return productDao.selectById(fid);
    }

    @Override
    public PageInfo<Fund> getPageInfo(int draw, int length, int start, Fund fund) {

        Map<String, Object> map = new HashMap<>();
        PageInfo<Fund> pageInfo = new PageInfo<>();
        int Count = productDao.getCount(fund);
        pageInfo.setRecordsFiltered(Count);
        pageInfo.setRecordsTotal(Count);
        pageInfo.setDraw(draw);
        map.put("length", length);
        map.put("start", start);
        map.put("fund", fund);
        pageInfo.setData(productDao.selectByPage(map));
        return pageInfo;

    }

    @Override
    public BaseResult save(Fund fund) {

        //BaseResult baseResult = checkTbContent(tbContent);
        String validator = BeanValidator.validator(fund);
        BaseResult baseResult = null;
        if (validator == null) {
            if(!checkup(fund)){
                return BaseResult.fail("基金名称已存在");
            }
            fund.setOpentradingdate(new Date());
            if(fund.getUnitPrice() != null && fund.getOverallscope() != null){
                mul = mul(fund.getUnitPrice(), (double) fund.getOverallscope());
            }else{
                baseResult = BaseResult.fail(validator);
            }
            fund.setTotalassets(mul);
            if (fund.getFid() == null) {
                if(fund.getPower()==0){
                    productDao.insertFund(fund);
                }else{
                    productDao.insertLoan(fund);
                }
            } else {
                //编辑内容
                if(fund.getPower()==0){
                    productDao.updateFund(fund);
                }else{
                    productDao.updateLoan(fund);
                }

            }
            baseResult = BaseResult.success("保存内容成功");
        } else {
            //验证不通过
            baseResult = BaseResult.fail(validator);
        }


        return baseResult;
    }
    public  Double mul(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.multiply(b2).doubleValue());
    }
    public boolean checkup(Fund fund){
        Fund fund1=productDao.checkup(fund);
        if(fund1==null){
            return true;
        }
        return false;
    }

    @Override

    public BaseResult deletemulti(String fids) {
        BaseResult baseResult = null;
        //验证ids不为空
        if (StringUtils.isNotBlank(fids)) {
            String[] fids_arr = fids.split(",");
            productDao.deletemulti(fids_arr);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public BaseResult deleteById(Long fid) {
        BaseResult baseResult = null;
        //验证ids不为空
        if (fid != null) {
            productDao.deleteById(fid);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
}
