package ro.unibuc.hello.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class StudentEntity {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Map<String, Integer> marks = new HashMap<>();

    public StudentEntity() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
