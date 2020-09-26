package com.litengxu.ltx_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.litengxu.ltx_web.dao")
@ServletComponentScan
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class LtxWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtxWebApplication.class, args);
	}

}
