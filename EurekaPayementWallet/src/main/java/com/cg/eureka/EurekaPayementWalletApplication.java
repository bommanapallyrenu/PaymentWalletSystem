package com.cg.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EurekaPayementWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaPayementWalletApplication.class, args);
	}

}
