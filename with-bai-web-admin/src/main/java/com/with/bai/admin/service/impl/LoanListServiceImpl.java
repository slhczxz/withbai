package com.with.bai.admin.service.impl;

import com.with.bai.admin.dao.LoanListDao;
import com.with.bai.admin.service.LoanListService;
import com.with.bai.domain.Fund;
import com.with.bai.domain.Loan;
import com.with.bai.dto.BaseResult;
import com.with.bai.dto.PageInfo;
import com.with.bai.validator.BeanValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoanListServiceImpl implements LoanListService {
    @Autowired
    LoanListDao loanListDao;

    @Override
    public Loan selectById(Long lid) {
        return loanListDao.selectById(lid);
    }

    @Override
    public PageInfo<Loan> getPageInfo(int draw, int start, int length, Loan loan) {

        Map<String, Object> map = new HashMap<>();
        PageInfo<Loan> pageInfo = new PageInfo<>();
        int Count = loanListDao.getCount(loan);
        pageInfo.setRecordsFiltered(Count);
        pageInfo.setRecordsTotal(Count);
        pageInfo.setDraw(draw);
        map.put("length", length);
        map.put("start", start);
        map.put("loan", loan);
        pageInfo.setData(loanListDao.selectByPage(map));
        return pageInfo;
    }

    @Override
    public BaseResult save(Loan loan) {

        String validator = BeanValidator.validator(loan);
        BaseResult baseResult = null;
        if (validator == null) {
            if(!checkup(loan)){
                return BaseResult.fail("贷款名称已存在");
            }
            if (loan.getLid() == null) {
               loanListDao.insert(loan);
            } else {
               loanListDao.update(loan);

            }
            baseResult = BaseResult.success("保存内容成功");
        } else {
            //验证不通过
            baseResult = BaseResult.fail(validator);
        }


        return baseResult;
    }
    public boolean checkup(Loan loan){
        Loan loan1=loanListDao.checkup(loan);
        if(loan1==null){
            return true;
        }
        return false;
    }

    @Override
    public BaseResult deletemulti(String lids) {
        BaseResult baseResult = null;
        //验证ids不为空
        if (StringUtils.isNotBlank(lids)) {
            String[] lids_arr = lids.split(",");
            loanListDao.deletemulti(lids_arr);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public BaseResult deleteById(Long lid) {
        BaseResult baseResult = null;
        //验证ids不为空
        if (lid != null) {
            loanListDao.deleteById(lid);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
}
