package com.cg.walletuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class WalletuserApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletuserApplication.class, args);
	}

}
