package ro.unibuc.Source.Data.Repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ro.unibuc.hello.data.ProfessorEntity;

@Repository
public interface ProfessorRepository extends MongoRepository<ProfessorEntity, String> {
    List<ProfessorEntity> findByFirstName(String firstName);
    List<ProfessorEntity> findByLastName(String lastName);

    List<ProfessorEntity> findByBirthday(Date birthday);
}