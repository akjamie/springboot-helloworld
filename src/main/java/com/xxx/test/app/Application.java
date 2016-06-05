package com.xxx.test.app;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration  
//@ComponentScan(basePackages="com.xxx.test")  
//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.xxx.test")
public class Application {

	// public static void main(String[] args) {
	// ConfigurableApplicationContext app = SpringApplication
	// .run(Application.class);
	// }

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(
				Application.class);
		//app.setBannerMode(Mode.CONSOLE);
		app.setBannerMode(Mode.OFF);
		app.run(args);
	}

}
