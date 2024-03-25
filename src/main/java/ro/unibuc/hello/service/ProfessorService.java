package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.unibuc.hello.dto.InformationDTO;
import ro.unibuc.hello.data.ProfessorRepository;
import ro.unibuc.hello.data.ProfessorEntity;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.concurrent.atomic.AtomicLong;

import java.util.List;

@Component
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    private final AtomicLong counter = new AtomicLong();

    public ProfessorEntity saveProfessor(ProfessorEntity professor) {
        return professorRepository.save(professor);
    }

    public void deleteProfessor(String id) {
        professorRepository.deleteById(id);
    }

    public ProfessorEntity updateProfessor(String id, ProfessorEntity professorDetails) {
        ProfessorEntity professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with id " + id));
        
        professor.firstName = (professorDetails.firstName);
        professor.lastName = (professorDetails.lastName);
        professor.classes = (professorDetails.classes);
        
        return professorRepository.save(professor);
    }

    public InformationDTO getProfessorByName(String name) throws EntityNotFoundException {
        List<ProfessorEntity> entities = professorRepository.findByFirstName(name);
        if (entities == null) {
            throw new EntityNotFoundException(name);
        }

        if (entities.size() == 0){
            return new InformationDTO(counter.incrementAndGet(), "NO PROFESSORS FOUND!");
        }

        String result = "";
        for (int i = 0; i < entities.size(); i++){
            ProfessorEntity entity = entities.get(i);
            result = result + entity.firstName + " " + entity.lastName + " \n\n";
        }

        return new InformationDTO(counter.incrementAndGet(), result);
    }

    public InformationDTO getAllProfessors() throws EntityNotFoundException{
        List<ProfessorEntity> entities = professorRepository.findAll();

        String result = "";
        for (int i = 0; i < entities.size(); i++){
            ProfessorEntity entity = entities.get(i);
            result = result + entity.firstName + " " + entity.lastName + " \n";
        }

        return new InformationDTO(counter.incrementAndGet(), result);
    }
}
