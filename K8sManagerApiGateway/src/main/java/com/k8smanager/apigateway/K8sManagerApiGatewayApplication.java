package com.k8smanager.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class K8sManagerApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sManagerApiGatewayApplication.class, args);
	}

}
