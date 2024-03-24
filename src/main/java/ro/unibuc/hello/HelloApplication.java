package ro.unibuc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ro.unibuc.hello.data.StudentRepository;
import ro.unibuc.hello.data.StudentEntity;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
public class HelloApplication {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@PostConstruct
	public void runAfterObjectCreated() {
		System.out.println("PERFECT RUN!");
		studentRepository.deleteAll();

        StudentEntity firstData = new StudentEntity();
        firstData.firstName = "Mihai";
        firstData.lastName = "Corolevschi";
        firstData.marks.put("Production Engineering", 10);
        firstData.marks.put("Programare avansata pe Obiecte", 5);

		studentRepository.save(firstData);
	}
}
