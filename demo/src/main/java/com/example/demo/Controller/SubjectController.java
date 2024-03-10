package com.example.demo.Controller;


import com.example.demo.Model.Subject;
import com.example.demo.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/all-subjects")
    public ResponseEntity<List<Subject>> getAllSubjects(){
        List<Subject> subjects = subjectService.getAllSubjects();

        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Subject> getSubjectByName(@PathVariable String name){
        Subject subject = subjectService.getSubjectByName(name);

        if(subject ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subject,HttpStatus.OK);
    }



    @GetMapping("/id/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id){
        Subject subject = subjectService.getSubjectById(id);
        if(subject==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subject,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
        Subject createdSubject = subjectService.addSubject(subject);
        return new ResponseEntity<>(createdSubject,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
