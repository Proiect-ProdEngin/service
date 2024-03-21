package ro.unibuc.Source.Data.Entities;

import org.springframework.data.annotation.Id;

public class TeachEntity {
    @Id
    public String id;

    public ProfessorEntity professor; // One to Many
    public StudyClassEntity StudyClass; // Many to One
}
