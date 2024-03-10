package com.example.demo.Repository;

import com.example.demo.Model.Question;
import com.example.demo.Model.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findAllBySubject(Subject subject);
}

