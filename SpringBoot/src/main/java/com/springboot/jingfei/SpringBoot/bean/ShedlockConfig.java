package com.springboot.jingfei.SpringBoot.bean;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

/**
 * 通过方法的方式注入bean
 */

@Configuration
@AutoConfigureAfter({DataSourceAutoConfiguration.class})
public class ShedlockConfig {

    @Bean
    public User user(WebApplicationContext applicationContext) {
        DataSource dataSource  = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource);
        return null;
    }
}
