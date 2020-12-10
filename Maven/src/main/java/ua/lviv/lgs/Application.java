package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.service.StudentService;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		StudentService service = ctx.getBean(StudentService.class);
		
		Student student = new Student();
		student.setName("Ivan");
		student.setAge(23);
		
		// save user to DB
		service.save(student);
		
		// read student from DB
		System.out.println(service.findById((Integer) 1));
		System.out.println(service.findByName("Ivan"));
		
		// update student info
		Student forUpdate = service.findById((Integer) 1);
		forUpdate.setAge(27);
		service.update(forUpdate);
		
		// readAll
		service.findAll().stream().forEach(System.out::println);
		
		// deleteById
//		service.deleteById((Integer) 1);
		
		
		
	}

}
