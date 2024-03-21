package ro.unibuc.Source.Data.Repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ro.unibuc.Source.Data.Entities.StudentEntity;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity, String> {
    List<StudentEntity> findByFirstName(String firstName);
    List<StudentEntity> findByLastName(String lastName);

    List<StudentEntity> findByBirthday(Date birthDate);
    List<StudentEntity> findByStudyStartYear(Date studyStartYear);
}