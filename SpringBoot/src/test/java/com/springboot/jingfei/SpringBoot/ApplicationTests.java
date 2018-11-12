package com.springboot.jingfei.SpringBoot;

import com.springboot.jingfei.SpringBoot.aop.OrderAsyncAopInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class ApplicationTests {

	@Autowired
	private OrderAsyncAopInterface orderAsyncAopInterface;
	/**
	 * 测试面向切面异步注解不起作用的情况
	 */
	@Test
	public void aopTest() {
		orderAsyncAopInterface.sendMessage();
	}

}
