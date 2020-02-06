/**
 * The SpringBootApplication works best from a base package. From here,
 * by default, it will scan this package and all sub-packages. It is possible
 * to tell it to scan other packages (with @ComponentScan(//packages), but it
 * is just easier to structure your application such that main is in the root.
 */
package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication  //Marks the application as a Spring Boot Application
						//This annotation encompasses several other annotations
						//including: @Configuration, @EnableAutoConfiguration
						//and @ComponentScan. If any of these annotations require
						//further configuration, they can be added without issue.
public class Application {
	
	public static void main(String[] args) {
		/**
		 * One of the features of Spring Boot is that it will deploy
		 * itself. When the main method is run, we call
		 * SpringApplication.run(Application.class, args); which will
		 * deploy your application to a Tomcat server spun up by the
		 * application for that purpose.
		 */
		SpringApplication.run(Application.class, args);
    }
	
}
