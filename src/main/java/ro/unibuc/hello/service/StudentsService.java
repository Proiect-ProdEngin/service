package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.unibuc.hello.dto.InformationDTO;
import ro.unibuc.hello.data.StudentRepository;
import ro.unibuc.hello.data.StudentEntity;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.concurrent.atomic.AtomicLong;

import java.util.List;

@Component
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    private final AtomicLong counter = new AtomicLong();

    public StudentEntity saveStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public StudentEntity updateStudent(String id, StudentEntity studentDetails) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        
        student.firstName = (studentDetails.firstName);
        student.lastName = (studentDetails.lastName);
        student.marks = (studentDetails.marks);
        
        return studentRepository.save(student);
    }

    public InformationDTO getStudentByName(String name) throws EntityNotFoundException {
        List<StudentEntity> entities = studentRepository.findByFirstName(name);
        System.out.println(entities);
        if (entities == null) {
            throw new EntityNotFoundException(name);
        }
        System.out.println(entities.size());

        if (entities.size() == 0){
            return new InformationDTO(counter.incrementAndGet(), "NO STUDENTS FOUND!");
        }

        String result = "";
        for (int i = 0; i < entities.size(); i++){
            StudentEntity entity = entities.get(i);
            result = result + entity.firstName + " " + entity.lastName + " \n\n";
        }

        return new InformationDTO(counter.incrementAndGet(), result);
    }

    public InformationDTO getAllStudents() throws EntityNotFoundException{
        List<StudentEntity> entities = studentRepository.findAll();

        String result = "";
        for (int i = 0; i < entities.size(); i++){
            StudentEntity entity = entities.get(i);
            result = result + entity.firstName + " " + entity.lastName + " \n";
        }

        return new InformationDTO(counter.incrementAndGet(), result);
    }
}
