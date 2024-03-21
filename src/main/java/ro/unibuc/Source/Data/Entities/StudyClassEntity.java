package ro.unibuc.Source.Data.Entities;

import org.springframework.data.annotation.Id;

public class StudyClassEntity {
    @Id
    public String id;
    
    public String classTitle;

    public StudyClassEntity() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
