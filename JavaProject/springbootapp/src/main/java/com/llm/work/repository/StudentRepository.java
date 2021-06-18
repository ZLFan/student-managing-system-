package com.llm.work.repository;

import com.llm.work.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
@Repository
public interface StudentRepository extends JpaRepository<com.llm.work.entity.Student,String> {
}
