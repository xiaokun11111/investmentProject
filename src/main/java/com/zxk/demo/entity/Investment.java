package com.zxk.demo.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhang Xiaokun
 * @date 2019-7-10 22:26
 */
public class Investment {


    private int investmentNumber;
    private String projectName;
    private String person;
    private int money;
    private Date beginDate;
    private Date endDate;
    private int actualMoney;
    private Date aBeginDate;
    private Date aEndDate;
    private String fileName;

    private String strDateFormat = "yyyy-MM-dd";
    private SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getInvestmentNumber() {
        return investmentNumber;
    }

    public void setInvestmentNumber(int investmentNumber) {
        this.investmentNumber = investmentNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(int actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Date getaBeginDate() {
        return aBeginDate;
    }

    public void setaBeginDate(Date aBeginDate) {
        this.aBeginDate = aBeginDate;
    }

    public Date getaEndDate() {
        return aEndDate;
    }

    public void setaEndDate(Date aEndDate) {
        this.aEndDate = aEndDate;
    }

    public Investment() {
    }

    public Investment(int investmentNumber, String projectName, String person, int money, Date beginDate, Date endDate, int actualMoney, Date aBeginDate, Date aEndDate) {
        this.investmentNumber = investmentNumber;
        this.projectName = projectName;
        this.person = person;
        this.money = money;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.actualMoney = actualMoney;
        this.aBeginDate = aBeginDate;
        this.aEndDate = aEndDate;


    }
}
