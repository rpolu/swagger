package com.bol.kalaha.assignment.application;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = { "com.bol.kalaha.assignment" })
public class Application {

	private final Environment env;

	public Application(Environment env) {
		this.env = env;
	}

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Application.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "dev"));
		Environment env = app.run(args).getEnvironment();

		System.out.println(env.getProperty("app.name") + env.getProperty("app.version") + env.getProperty("server.port")
				+ env.getActiveProfiles());

	}
}
