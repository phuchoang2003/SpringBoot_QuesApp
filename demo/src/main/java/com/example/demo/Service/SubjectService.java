package com.example.demo.Service;

import com.example.demo.Model.Subject;
import com.example.demo.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubjectService  {

    @Autowired
    private SubjectRepository subjectRepository;
    public List<Subject> getAllSubjects(){

        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id){
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject getSubjectByName(String name){
        return subjectRepository.findByName(name);
    }

    public Subject addSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id){
         subjectRepository.deleteById(id);

    }
}
