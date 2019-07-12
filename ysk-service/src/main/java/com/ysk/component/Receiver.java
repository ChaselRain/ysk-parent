package com.ysk.component;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ysk.App;

@Component
public class Receiver {
	
	private static Logger logger = Logger.getLogger(App.class);

	@RabbitListener(queues = "hello.queue1")
	public String processMessage1(String msg) {
		logger.info(Thread.currentThread().getName() + " 接收到来自hello.queue1队列的消息：" + msg);
		return msg.toUpperCase();
	}

	@RabbitListener(queues = "hello.queue2")
	public void processMessage2(String msg) {
		logger.info(Thread.currentThread().getName() + " 接收到来自hello.queue2队列的消息：" + msg);
	}
}