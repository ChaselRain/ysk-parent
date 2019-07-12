package com.ysk;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class}*/)
@ImportResource({"classpath:config/spring-dubbo.xml"})
@MapperScan("com.ysk.resource")
@ComponentScan({"com.ysk.config","com.ysk.component"})
public class App {

	private static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		logger.info("SpringBoot Start Success");
	}

}
