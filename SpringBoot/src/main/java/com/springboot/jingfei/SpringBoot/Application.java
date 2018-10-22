package com.springboot.jingfei.SpringBoot;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * 注意事项：启动类所处于的包必须要包含要访问的路径所在的包
 * @author ZXPH
 *
 */
@SpringBootApplication
public class Application {

	/**
	 * @Bean 注解相当于在xml里的配置
	 * <bean id="queue" class="ActiveMQQueue"/>
	 * 在这里注册一个队列，promoteAct为队列名称
	 * @Bean 注解一般用在@Configuration注解下
	 * @return new ActiveMQQueue()
	 */
	@Bean
	public ActiveMQQueue queue(){
		return new ActiveMQQueue("promoteAct");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
