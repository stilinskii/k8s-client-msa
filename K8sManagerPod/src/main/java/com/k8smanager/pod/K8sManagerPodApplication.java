package com.k8smanager.pod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class K8sManagerPodApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sManagerPodApplication.class, args);
	}

}
