package ro.unibuc.Source.Data.Entities;

import org.springframework.data.annotation.Id;

public class StudyEntity {
    @Id
    public String id;

    public int mark;

    public StudentEntity Student; // One to Many
    public StudyClassEntity StudyClass; // Many to One
}
