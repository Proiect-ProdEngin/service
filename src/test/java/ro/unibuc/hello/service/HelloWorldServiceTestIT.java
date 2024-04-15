package ro.unibuc.hello.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.InformationRepository;
import ro.unibuc.hello.data.ProfessorEntity;
import ro.unibuc.hello.data.ProfessorRepository;
import ro.unibuc.hello.data.StudentEntity;
import ro.unibuc.hello.data.StudentRepository;
import ro.unibuc.hello.dto.Greeting;
import ro.unibuc.hello.dto.InformationDTO;

@SpringBootTest
@Tag("IT")
class HelloWorldServiceTestIT {

    @Autowired
    private StudentsService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    public void testStudentCreationAndGet() {
        // Arrange
        StudentEntity student = new StudentEntity();
        student.firstName = "Mihai TEST";
        student.lastName = "Corolevschi TEST";
        studentRepository.save(student);

        // Act
        InformationDTO found = studentService.getStudentByName(student.firstName);

        // Assert
        assertNotNull(found);
        assertEquals("Mihai TEST Corolevschi TEST \n\n", found.getContent());
    }
    @Test
    public void testStudentCreationUpdateAndGet() {
        // Arrange
        StudentEntity student = new StudentEntity();
        student.firstName = "Mihai TEST";
        student.lastName = "Corolevschi TEST";
        studentRepository.save(student);

        // Act
        student.firstName = "Sebi TEST";
        student.lastName = "Mustatoiu TEST";
        studentService.updateStudent(student.id, student);

        InformationDTO found = studentService.getStudentByName(student.firstName);

        // Assert
        assertNotNull(found);
        assertEquals("Sebi TEST Mustatoiu TEST \n\n", found.getContent());
    }
    @Test
    public void testStudentCreationAndDelete() {
        // Arrange
        StudentEntity student = new StudentEntity();
        student.firstName = "Mihai TEST";
        student.lastName = "Corolevschi TEST";
        studentRepository.save(student);

        // Act
        String studentId = student.id;
        studentService.deleteStudent(studentId);

        Optional<StudentEntity> deleted = studentRepository.findById(studentId);

        // Assert
        assertFalse(deleted.isPresent(), "The student should no longer exist in the database.");
    }

    @Test
    public void testProfessorCreationAndGet() {
        // Arrange
        ProfessorEntity professor = new ProfessorEntity();
        professor.firstName = "Andrei TEST";
        professor.lastName = "Paunescu TEST";
        professorRepository.save(professor);

        // Act
        professor.firstName = "Anca TEST";
        professor.lastName = "Dobrovat TEST";
        professorService.updateProfessor(professor.id, professor);

        InformationDTO found = professorService.getProfessorByName(professor.firstName);

        // Assert
        assertNotNull(found);
        assertEquals("Anca TEST Dobrovat TEST \n\n", found.getContent());
    }
    @Test
    public void testProfessorCreationUpdateAndGet() {
        // Arrange
        ProfessorEntity professor = new ProfessorEntity();
        professor.firstName = "Andrei TEST";
        professor.lastName = "Paunescu TEST";
        professorRepository.save(professor);

        // Act
        InformationDTO found = professorService.getProfessorByName(professor.firstName);

        // Assert
        assertNotNull(found);
        assertEquals("Andrei TEST Paunescu TEST \n\n", found.getContent());
    }
    @Test
    public void testProfessorCreationAndDelete() {
        // Arrange
        ProfessorEntity professor = new ProfessorEntity();
        professor.firstName = "Andrei TEST";
        professor.lastName = "Paunescu TEST";
        professorRepository.save(professor);

        // Act
        String professorId = professor.id;
        professorService.deleteProfessor(professorId);

        Optional<ProfessorEntity> deleted = professorRepository.findById(professorId);

        // Assert
        assertFalse(deleted.isPresent(), "The professor should no longer exist in the database.");
    }
}