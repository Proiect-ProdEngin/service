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

import ro.unibuc.hello.data.ProfessorEntity;
import ro.unibuc.hello.dto.InformationDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.ProfessorService;

@Controller
public class ProfessorsController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/professor") // CREATE PROFESSOR
    public ResponseEntity<ProfessorEntity> addProfessor(@RequestBody ProfessorEntity professor) {
        ProfessorEntity savedProfessor = professorService.saveProfessor(professor);
        return ResponseEntity.ok(savedProfessor);
    }

    @DeleteMapping("/professor/{id}") // DELETE PROFESSOR
    public ResponseEntity<?> deleteProfessor(@PathVariable String id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/professor/{id}") // UPDATE PROFESSOR
    public ResponseEntity<ProfessorEntity> updateProfessor(@PathVariable String id, @RequestBody ProfessorEntity professorDetails) {
        ProfessorEntity updatedProfessor = professorService.updateProfessor(id, professorDetails);
        return ResponseEntity.ok(updatedProfessor);
    }

    @GetMapping("/professor/{firstName}") // GET PROFESSOR BY NAME
    @ResponseBody
    public InformationDTO professor(@PathVariable("firstName") String firstName) throws EntityNotFoundException {
        return professorService.getProfessorByName(firstName);
    }

    @GetMapping("/professors") // GET ALL PROFESSORS
    @ResponseBody
    public InformationDTO professor() throws EntityNotFoundException {
        return professorService.getAllProfessors();
    }

}