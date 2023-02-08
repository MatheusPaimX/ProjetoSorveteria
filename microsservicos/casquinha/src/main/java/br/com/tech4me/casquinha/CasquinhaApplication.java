package br.com.tech4me.casquinha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CasquinhaApplication{

	public static void main(String[] args) {
		SpringApplication.run(CasquinhaApplication.class, args);
	}

}
