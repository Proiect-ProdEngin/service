package ro.unibuc.hello.data;

import java.sql.Date;

import java.util.List;

import org.springframework.data.annotation.Id;

public class ProfessorEntity {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Date birthday;

    public List<String> classes;

    public ProfessorEntity() {}

    @Override
    public String toString() {
        return super.toString();
    }
}