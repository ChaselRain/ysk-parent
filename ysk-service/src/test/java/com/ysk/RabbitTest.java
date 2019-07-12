package com.ysk;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ysk.component.Sender;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RabbitTest {

	@Autowired
	private Sender sender;

	@Test
	public void sendTest() throws Exception {
		for (int i = 0; i < 3; i++) {
			String msg = new Date().toString();
			sender.send(msg);
			Thread.sleep(2000);
		}
	}
}
