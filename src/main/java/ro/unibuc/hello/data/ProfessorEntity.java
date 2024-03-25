package ro.unibuc.hello.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class ProfessorEntity {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public List<String> classes = new ArrayList<>();

    public ProfessorEntity() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
