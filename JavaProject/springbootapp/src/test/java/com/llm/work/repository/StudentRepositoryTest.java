package com.llm.work.repository;
import com.llm.work.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired(required = false)
    private StudentRepository studentRepository;
    @Test
    void findAll()
    {
        System.out.println(studentRepository.findAll());

    }
}
