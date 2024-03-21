package ro.unibuc.Source.Data.Entities;

import java.sql.Date;

import org.springframework.data.annotation.Id;

public class StudentEntity {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Date birthDate;
    
    public Date studyStartYear; // the year the student started studying

    public StudentEntity() {}

    @Override
    public String toString() {
        return super.toString();
    }
}