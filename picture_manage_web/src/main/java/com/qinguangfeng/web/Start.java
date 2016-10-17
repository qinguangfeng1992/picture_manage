package com.qinguangfeng.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by dengjicheng on 2016/10/8.
 * 启动项
 */
@SpringBootApplication
@MapperScan("com.qinguangfeng.dao.mapper")
@ComponentScan({"com.qinguangfeng.web.service", "com.fc", "com.qinguangfeng.web.controller"})
public class Start extends SpringBootServletInitializer {

}
