package ro.unibuc.hello.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends MongoRepository<ProfessorEntity, String> {
    List<ProfessorEntity> findByFirstName(String firstName);
    List<ProfessorEntity> findByLastName(String lastName);
}
