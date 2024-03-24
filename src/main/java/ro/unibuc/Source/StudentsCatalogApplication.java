package ro.unibuc.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import ro.unibuc.Source.Data.Repositories.StudentRepository;
import ro.unibuc.hello.data.StudentEntity;

import java.sql.Date;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
public class StudentsCatalogApplication {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentsCatalogApplication.class, args);
	}

	@PostConstruct
	public void runAfterObjectCreated() {
		studentRepository.deleteAll();

        StudentEntity firstData = new StudentEntity();
        firstData.firstName = "Mihai";
        firstData.lastName = "Corolevschi";
        firstData.marks.put("Production Engineering", 10);
        firstData.marks.put("Programare avansata pe Obiecte", 5);
        firstData.studyStartYear = new Date(0);
        firstData.birthday = new Date(0);

		studentRepository.save(firstData);
	}

}
