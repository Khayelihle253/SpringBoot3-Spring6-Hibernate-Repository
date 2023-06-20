package com.khayelihle.springboot3_spring6_hibernate;

import com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.dao.StudentDAO;
import com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.entity.Student;
import com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.dao.AppDAO;
import com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.entity.Instructor;
import com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
	 //* @param studentDAO
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			//createStudents(studentDAO);
			//readStudent(studentDAO);
			//readStudents(studentDAO);
			//readStudentsByLastName(studentDAO);\
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteStudentAll(studentDAO);

			//section 9
			createInstructor(appDAO);

		}; //java lambda expression
	}

	private void createInstructor(AppDAO appDAO) {
		//create instructor
		Instructor instructor = new Instructor("Khaye","Ngcobo","khaye@gmail.com");

		//create instructor details
		InstructorDetail instructorDetail = new InstructorDetail("https://www.khaye.com/youtube","Coding");

		//associate the objects
		instructor.setInstructorDetail(instructorDetail);

		//save the instructor, this will also save the details object because of CascadeType.ALL
		System.out.println("Saving the instructor" + instructor);
		appDAO.save(instructor);
		System.out.println("Done!");

	}

	private void deleteStudentAll(StudentDAO studentDAO) {
		//display all students before deletion
		System.out.println("All students before deletion: " + studentDAO.findAll());

		//delete all students from the database
		studentDAO.deleteAll();

		//display all students after deletion
		System.out.println("All students after deletion: " + studentDAO.findAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//id of the student to be deleted
		int id = 1;

		//retrieve all records before deletion
		System.out.println("All students before deletion: " + studentDAO.findAll());

		//delete student
		studentDAO.delete(id);

		//retrieve all records after deletion
		System.out.println("All students after deletion: " + studentDAO.findAll());

	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student by id; primary key
		Student student = studentDAO.findById(1);
		System.out.println("Student: " + student);

		//change first name to "Khaye"
		student.setFirstName("Khaye");

		//update the student
		studentDAO.update(student);

		//display the updated student
		Student updatedStudent = studentDAO.findById(1);
		System.out.println("Updated student: " + updatedStudent);
	}

	private void readStudentsByLastName(StudentDAO studentDAO) {
		//get the list of students
		List<Student> students = studentDAO.findByLastName("Ngcobo");

		//loop through the list and display all students with lastname
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void readStudents(StudentDAO studentDAO) {
		//get the list of students
		List<Student> students = studentDAO.findAll();

		//loop through the list and display all students
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create student object
		Student tempStudent = new Student("Khayelihle1","Ngcobo1","khayelihle1@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//retrieve the saved student object by id
		System.out.println(studentDAO.findById(tempStudent.getId()));

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
