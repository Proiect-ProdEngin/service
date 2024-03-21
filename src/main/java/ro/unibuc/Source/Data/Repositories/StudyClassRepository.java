package ro.unibuc.Source.Data.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ro.unibuc.Source.Data.Entities.StudyClassEntity;

@Repository
public interface StudyClassRepository extends MongoRepository<StudyClassEntity, String> {
    List<StudyClassEntity> findByClassTitle(String classTitle);
}