package com.k8smanager.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class K8sManagerDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sManagerDiscoveryServiceApplication.class, args);
	}

}
