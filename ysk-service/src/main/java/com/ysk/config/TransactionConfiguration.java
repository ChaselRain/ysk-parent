package com.ysk.config;

import java.util.Properties;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
public class TransactionConfiguration {

	@Bean(name = "transactionInterceptor")
	public TransactionInterceptor transactionInterceptor(PlatformTransactionManager platformTransactionManager) {
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		// 事物管理器
		transactionInterceptor.setTransactionManager(platformTransactionManager);
		Properties transactionAttributes = new Properties();

		// 新增
		transactionAttributes.setProperty("insert*", "PROPAGATION_REQUIRED,-Throwable");
		// 修改
		transactionAttributes.setProperty("update*", "PROPAGATION_REQUIRED,-Throwable");
		// 删除
		transactionAttributes.setProperty("delete*", "PROPAGATION_REQUIRED,-Throwable");
		// 查询
		transactionAttributes.setProperty("select*", "PROPAGATION_REQUIRED,-Throwable, readOnly");

		transactionInterceptor.setTransactionAttributes(transactionAttributes);
		return transactionInterceptor;
	}

	// 代理到ServiceImpl的Bean
	@Bean
	public BeanNameAutoProxyCreator transactionAutoProxy() {
		BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
		transactionAutoProxy.setProxyTargetClass(true);
		transactionAutoProxy.setBeanNames("*ServiceImpl");
		transactionAutoProxy.setInterceptorNames("transactionInterceptor");
		return transactionAutoProxy;
	}
}
