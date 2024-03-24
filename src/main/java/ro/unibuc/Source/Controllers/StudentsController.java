package ro.unibuc.Source.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.unibuc.Source.Data.DTO.InformationDTO;
import ro.unibuc.Source.Services.StudentsService;
import ro.unibuc.hello.exception.EntityNotFoundException;

@Controller
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/student/{firstName}")
    @ResponseBody
    public InformationDTO student(@RequestParam(name="firstName", required=false) String firstName) throws EntityNotFoundException {
        return studentsService.getStudentByName(firstName);
    }

    @GetMapping("/student/all")
    @ResponseBody
    public InformationDTO student() throws EntityNotFoundException {
        return studentsService.getAllStudents();
    }

}
