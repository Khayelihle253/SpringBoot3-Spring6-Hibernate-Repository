package com.khayelihle.springboot3_spring6_hibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The default @SpringBootApplication enables:
 *  - Auto configuration (@EnableAutoConfiguration): enables spring boot's autoconfiguration support
 *  - Component scanning (@ComponentScan): enables component scanning of current package, and recursively scans the sub-packages
 *  - Additional configuration (@Configuration): able to register extra beans with @Bean or import other configuration classes
 *
 *  behind the scenes this class:
 *  - creates the application context, and registers the beans, and starts the embedded server
 */

//@SpringBootApplication
//for scanning packages including those out of the spring boot application package, you have to explicitly specify which packages to scan:
@SpringBootApplication(scanBasePackages={"com.khayelihle.springboot3_spring6_hibernate","com.khayelihle.util"})
public class Springboot3Spring6HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3Spring6HibernateApplication.class, args);
	}

	/**
	 * creating a command-line application
	 *  - this method will be executed after the spring beans have been loaded
	 * @param args
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner ->{ System.out.println("Hello World"); }; //java lambda expression
	}

}
