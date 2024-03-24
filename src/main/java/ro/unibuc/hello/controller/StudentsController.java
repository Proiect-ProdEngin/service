package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.unibuc.hello.data.StudentEntity;
import ro.unibuc.hello.dto.InformationDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.StudentsService;

@Controller
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @PostMapping("/student") // CREATE STUDENT
    public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity student) {
        StudentEntity savedStudent = studentsService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/student/{id}") // DELETE STUDENT
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        studentsService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/student/{id}") // UPDATE STUDENT
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable String id, @RequestBody StudentEntity studentDetails) {
        StudentEntity updatedStudent = studentsService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/student/{firstName}") // GET STUDENT BY NAME
    @ResponseBody
    public InformationDTO student(@PathVariable("firstName") String firstName) throws EntityNotFoundException {
        return studentsService.getStudentByName(firstName);
    }

    @GetMapping("/students") // GET ALL STUDENTS
    @ResponseBody
    public InformationDTO student() throws EntityNotFoundException {
        return studentsService.getAllStudents();
    }

}