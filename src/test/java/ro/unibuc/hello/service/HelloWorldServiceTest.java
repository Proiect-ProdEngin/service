package ro.unibuc.hello.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import ro.unibuc.hello.data.InformationEntity;
import ro.unibuc.hello.data.InformationRepository;
import ro.unibuc.hello.data.ProfessorEntity;
import ro.unibuc.hello.data.ProfessorRepository;
import ro.unibuc.hello.data.StudentEntity;
import ro.unibuc.hello.data.StudentRepository;
import ro.unibuc.hello.dto.Greeting;
import ro.unibuc.hello.dto.InformationDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class HelloWorldServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private ProfessorRepository professorRepository;

    @InjectMocks
    private StudentsService studentService;
    @InjectMocks
    private ProfessorService professorService;

    @Test
    public void testFindStudentByFirstName() {
        StudentEntity student = new StudentEntity();
        student.firstName = "Mihai LOL";
        student.lastName = "LOLOLOLOL";
        List<StudentEntity> retList = new ArrayList<>();
        retList.add(student);
        when(studentRepository.findByFirstName("Mihai LOL")).thenReturn(retList);

        // Execute the service call
        InformationDTO found = studentService.getStudentByName("Mihai LOL");

        String retString = student.firstName + " " + student.lastName + " \n\n";

        assertEquals(retString, found.getContent(), "The name of the student should be " + student.firstName + " " + student.lastName + " \n\n");
    }
    @Test
    public void testUpdateOrSaveStudent() {
        StudentEntity updatedOrSavedStudent = new StudentEntity();
        updatedOrSavedStudent.id = "SomeSortOfStudentIdIDKWhatItIs";
        updatedOrSavedStudent.firstName = "Sebi TEST";
        updatedOrSavedStudent.lastName = "Mustatoiu TEST";
    
        when(studentRepository.findById("SomeSortOfStudentIdIDKWhatItIs")).thenReturn(Optional.of(updatedOrSavedStudent));
        when(studentRepository.save(any(StudentEntity.class))).thenReturn(updatedOrSavedStudent);
        
        StudentEntity result = studentService.updateStudent(updatedOrSavedStudent.id, updatedOrSavedStudent);
        
        assertEquals("Sebi TEST", result.firstName, "First name should be updated.");
        assertEquals("Mustatoiu TEST", result.lastName, "Last name should be updated.");
    }
    @Test
    public void testDeleteStudentById() {
        String studentId = "SomeSortOfStudentIdIDKWhatItIs";
        doNothing().when(studentRepository).deleteById(studentId);
        
        studentService.deleteStudent(studentId);
        
        verify(studentRepository).deleteById(studentId);
    }

    @Test
    public void testFindProfessorByFirstName() {
        ProfessorEntity professor = new ProfessorEntity();
        professor.firstName = "Andrei TEST";
        professor.lastName = "Paun TEST";
        List<ProfessorEntity> retList = new ArrayList<>();
        retList.add(professor);
        when(professorRepository.findByFirstName("Andrei TEST")).thenReturn(retList);

        // Execute the service call
        InformationDTO found = professorService.getProfessorByName("Andrei TEST");

        String retString = professor.firstName + " " + professor.lastName + " \n\n";

        assertEquals(retString, found.getContent(), "The name of the professor should be " + professor.firstName + " " + professor.lastName + " \n\n");
    }
    @Test
    public void testUpdateOrSaveProfessor() {
        ProfessorEntity updatedOrSavedProfessor = new ProfessorEntity();
        updatedOrSavedProfessor.id = "SomeSortOfProfessorIdIDKWhatItIs";
        updatedOrSavedProfessor.firstName = "Anca TEST";
        updatedOrSavedProfessor.lastName = "Dobrovat TEST";
    
        when(professorRepository.findById("SomeSortOfProfessorIdIDKWhatItIs")).thenReturn(Optional.of(updatedOrSavedProfessor));
        when(professorRepository.save(any(ProfessorEntity.class))).thenReturn(updatedOrSavedProfessor);
        
        ProfessorEntity result = professorService.updateProfessor(updatedOrSavedProfessor.id, updatedOrSavedProfessor);
        
        assertEquals("Anca TEST", result.firstName, "First name should be updated.");
        assertEquals("Dobrovat TEST", result.lastName, "Last name should be updated.");
    }
    @Test
    public void testDeleteProfessorById() {
        String professorId = "SomeSortOfProfessorIdIDKWhatItIs";
        doNothing().when(professorRepository).deleteById(professorId);
        
        professorService.deleteProfessor(professorId);
        
        verify(professorRepository).deleteById(professorId);
    }
}