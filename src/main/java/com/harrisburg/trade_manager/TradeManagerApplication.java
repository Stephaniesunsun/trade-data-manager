package com.harrisburg.trade_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(org.apache.camel.spring.boot.CamelAutoConfiguration.class)
@EnableJpaRepositories("com.harrisburg.trade_manager.repository")
public class TradeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeManagerApplication.class, args);
	}

}
