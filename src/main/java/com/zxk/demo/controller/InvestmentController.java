package com.zxk.demo.controller;

import com.zxk.demo.dto.InvestmentDto;
import com.zxk.demo.entity.Investment;
import com.zxk.demo.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@RestController
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping("/app/{number}")
    public List<InvestmentDto> find(@PathVariable("number") Integer number){
        return investmentService.findInvestmentByNumber(number);
    }

    @GetMapping("/all")
    public List findAll(){
        return investmentService.findAll();
    }

    @GetMapping("/apps/{number}")
    public int findInt(@PathVariable("number") Integer number){
        return investmentService.findInt(number);
    }

    @GetMapping(value="/appss/")
    public String findInts(){
        return "Hello World!";
    }

    @RequestMapping(value = "/add")
    public void add(@RequestBody(required = false) Investment investment){
        investmentService.add(investment);
    }

    @GetMapping(value="/search")
    public List<InvestmentDto> search( Integer investmentNumber, String projectName, String person){
        return investmentService.search(investmentNumber,projectName,person);
    }
    @RequestMapping("/del/{investmentNumber}")
    public void del(@PathVariable("investmentNumber") int investmentNumber){
        investmentService.del(investmentNumber);
    }

}
