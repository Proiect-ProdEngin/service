package ro.unibuc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ro.unibuc.hello.data.StudentRepository;
import ro.unibuc.hello.data.ProfessorEntity;
import ro.unibuc.hello.data.ProfessorRepository;
import ro.unibuc.hello.data.StudentEntity;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {StudentRepository.class, ProfessorRepository.class})
public class HelloApplication {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ProfessorRepository professorRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@PostConstruct
	public void runAfterObjectCreated() {
		System.out.println("PERFECT RUN!");
		studentRepository.deleteAll();
		professorRepository.deleteAll();

        StudentEntity firstData = new StudentEntity();
        firstData.firstName = "Mihai";
        firstData.lastName = "Corolevschi";
        firstData.marks.put("Production Engineering", 10);
        firstData.marks.put("Programare avansata pe Obiecte", 5);

		studentRepository.save(firstData);

		ProfessorEntity secondData = new ProfessorEntity();
		secondData.firstName = "Andrei";
		secondData.lastName = "Paun";
		secondData.classes.add("Limbaje Formale si Automate");
		secondData.classes.add("Programare orientata pe Obiecte");
		secondData.classes.add("Initiere in Cercetare in Bioinformatica");

		ProfessorEntity thirdData = new ProfessorEntity();
		thirdData.firstName = "Radu";
		thirdData.lastName = "Boriga";
		thirdData.classes.add("Programare Algoritmilor");
		thirdData.classes.add("Programare Avansata pe Obiecte");

		professorRepository.save(secondData);
		professorRepository.save(thirdData);
	}
}
