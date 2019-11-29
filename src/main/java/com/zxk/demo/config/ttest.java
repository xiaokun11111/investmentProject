package com.zxk.demo.config;

import java.util.regex.Pattern;

public class ttest {


    public static void main(String args[]){
        String fileName="201909001";
        //String pattern="\\d{4}(0?[1-9]|[1][012])(0?[1-9]|[12][0-9]|3[01])[0-9]{3}";
        String pattern="\\d{4}(0[1-9]|[1][012])[0-9]{3}";
        System.out.println(fileName.matches(pattern));

    }
}
