package ro.unibuc.hello.data;

import java.sql.Date;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class StudentEntity {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Date birthday;
    
    public Date studyStartYear; // the year the student started studying

    public Map<String, Integer> marks;

    public StudentEntity() {}

    @Override
    public String toString() {
        return super.toString();
    }
}