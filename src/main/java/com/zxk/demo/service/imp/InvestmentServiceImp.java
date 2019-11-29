package com.zxk.demo.service.imp;

import com.zxk.demo.dao.InvestmentDao;
import com.zxk.demo.dto.InvestmentDto;
import com.zxk.demo.entity.Investment;
import com.zxk.demo.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhang Xiaokun
 * @date 2019-7-10 22:36
 */
@Service
public class InvestmentServiceImp implements InvestmentService {
    @Autowired
    private InvestmentDao investmentDao;

    @Override
    public List<InvestmentDto> findInvestmentByNumber(int number){
        return investmentDao.findInvestmentByNumber(number);
    }

    @Override
    public List<InvestmentDto> findAll(){
        return investmentDao.findAll();
    }

    @Override
    public int findInt(int number){
        return investmentDao.findInt(number);
    }


    @Override
    public void add(Investment investment){
        investmentDao.add(investment);
    }

    @Override
    public List<InvestmentDto> search(Integer investmentNumber,String projectName,String person){
        return investmentDao.search(investmentNumber,projectName,person);
    }

    @Override
    public void del(int investmentNumber){
        investmentDao.del(investmentNumber);
    }
    @Override
    public void updateFile (Integer investmentNumber){
        investmentDao.updateFile(investmentNumber);
    }
}
