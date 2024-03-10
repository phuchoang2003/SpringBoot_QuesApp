package com.example.demo.Repository;

import com.example.demo.Model.DetailOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailOptionRepository extends JpaRepository<DetailOption,Long> {
}
