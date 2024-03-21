package ro.unibuc.Source.Data.Entities;

import java.sql.Date;

import org.springframework.data.annotation.Id;

public class ProfessorEntity {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Date birthDate;

    public ProfessorEntity() {}

    @Override
    public String toString() {
        return super.toString();
    }
}