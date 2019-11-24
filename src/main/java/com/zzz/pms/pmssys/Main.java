package com.zzz.pms.pmssys;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class Main {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Main.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
