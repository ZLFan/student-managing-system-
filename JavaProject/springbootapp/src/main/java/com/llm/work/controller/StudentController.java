package com.llm.work.controller;

import com.llm.work.entity.Student;
import com.llm.work.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/findAll")
    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }
    @PostMapping("/save")
    public String save(@RequestBody Student student)
    {
        Student result = studentRepository.save(student);
        if(result!=null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }
    @GetMapping("/findById/{stunum}")
    public Student findById(@PathVariable("stunum") String stunum)
    {
        return studentRepository.findById(stunum).get();
    }
    @DeleteMapping("/deleteById/{stunum}")
    public void deleteByMapping(@PathVariable("stunum") String stunum)
    {
        studentRepository.deleteById(stunum);
    }
}
