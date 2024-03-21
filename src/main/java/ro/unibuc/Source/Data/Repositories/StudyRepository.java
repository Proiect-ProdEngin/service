package ro.unibuc.Source.Data.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ro.unibuc.Source.Data.Entities.StudyEntity;

@Repository
public interface StudyRepository extends MongoRepository<StudyEntity, String> {
    List<StudyEntity> findByClassMark(int mark);
}