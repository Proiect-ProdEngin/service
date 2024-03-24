package ro.unibuc.Source.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.unibuc.Source.Data.DTO.InformationDTO;
import ro.unibuc.Source.Data.Repositories.StudentRepository;
import ro.unibuc.hello.data.StudentEntity;
import ro.unibuc.hello.dto.Greeting;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.concurrent.atomic.AtomicLong;

import java.util.List;

@Component
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    private final AtomicLong counter = new AtomicLong();

    public InformationDTO getStudentByName(String name) throws EntityNotFoundException {
        List<StudentEntity> entities = studentRepository.findByFirstName(name);
        if (entities == null) {
            throw new EntityNotFoundException(name);
        }

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
            result = result + entity.firstName + " " + entity.lastName + " \n\n";
        }

        return new InformationDTO(counter.incrementAndGet(), result);
    }
}
