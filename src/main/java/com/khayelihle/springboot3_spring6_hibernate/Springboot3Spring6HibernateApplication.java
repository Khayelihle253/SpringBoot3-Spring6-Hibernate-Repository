package com.khayelihle.springboot3_spring6_hibernate;

import com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.dao.StudentDAO;
import com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.entity.Student;
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
	 * @param studentDAO
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudents(studentDAO);
		}; //java lambda expression
	}

	private void createStudents(StudentDAO studentDAO) {

		//creating student objects
		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("Khayelihle1","Ngcobo1","khayelihle1@gmail.com");
		Student tempStudent2 = new Student("Khayelihle2","Ngcobo2","khayelihle2@gmail.com");

		//save the student objects and display the id of the saved student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent2);
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());

	}

}
