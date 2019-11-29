package com.zxk.demo.config;



import com.zxk.demo.convert.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;


public class ConverterConfig {

 @Autowired
 private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct
    public void initEditableAvlidation() {

            ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
            if(initializer.getConversionService()!=null) {
                GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();

                // 注册日期类型转换器
                genericConversionService.addConverter(new DateConverter());
            }
    }
}
