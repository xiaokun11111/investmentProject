package com.zxk.demo.service;

import com.zxk.demo.dto.InvestmentDto;
import com.zxk.demo.entity.Investment;

import java.util.List;

/**
 * @author Zhang Xiaokun
 * @date 2019-7-10 22:35
 */
public interface InvestmentService {
    public List<InvestmentDto> findInvestmentByNumber(int number);
    public List<InvestmentDto> findAll();
    public int findInt(int number);
    public void add(Investment investment);
    public void del(int investmentNumber);
    public void updateFile (Integer investmentNumber);
    public List<InvestmentDto> search(Integer investmentNumber,String projectName,String person);
}
