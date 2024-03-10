package com.example.demo.Repository;

import com.example.demo.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    Subject findByName(String name);

}
