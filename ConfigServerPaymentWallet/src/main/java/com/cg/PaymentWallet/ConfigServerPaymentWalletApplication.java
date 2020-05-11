package com.cg.PaymentWallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerPaymentWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerPaymentWalletApplication.class, args);
	}

}
