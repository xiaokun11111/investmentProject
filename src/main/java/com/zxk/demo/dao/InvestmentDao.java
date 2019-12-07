package com.zxk.demo.dao;

import com.zxk.demo.dto.InvestmentDto;
import com.zxk.demo.entity.Investment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhang Xiaokun
 * @date 2019-7-10 22:32
 */

@Mapper
public interface InvestmentDao {

    public List<InvestmentDto> findInvestmentByNumber(int number);
    public List<InvestmentDto> findAll();
    public int findInt(int number);
    public void add(Investment investment);
    public void del(@Param("investmentNumber") int investmentNumber);
    public void updateFile (@Param("investmentNumber") Integer investmentNumber);
    public List<InvestmentDto> search(@Param("investmentNumber") Integer investmentNumber, @Param("projectName") String projectName, @Param("person") String person);
}
