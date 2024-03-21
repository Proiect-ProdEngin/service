package ro.unibuc.Source.Data.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ro.unibuc.Source.Data.Entities.TeachEntity;

@Repository
public interface TeachRepository extends MongoRepository<TeachEntity, String> {
}