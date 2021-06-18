package com.llm.work.controller;

import com.llm.work.entity.Teacher;
import com.llm.work.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")

public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping("/findAll")
    public List<Teacher> findAll()
    {
        //Pageable pageable = PageRequest.of(page,size);
        return teacherRepository.findAll();
    }
    @PostMapping("/save")
    public String save(@RequestBody Teacher teacher)
    {
        Teacher result = teacherRepository.save(teacher);
        if(result!=null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }
    @GetMapping("/findById/{teanum}")
    public Teacher findById(@PathVariable("teanum") String teanum)
    {
        return teacherRepository.findById(teanum).get();
    }
//    @GetMapping("/getTeanameByTeanum/{teanum}")
//    public String getTeanameByTeanum(@PathVariable("teanum") String teanum)
//    {
//        return getTeanameByTeanum(teanum);
//    }
    @DeleteMapping("/deleteById/{teanum}")
    public void deleteByMapping(@PathVariable("teanum") String teanum)
    {
        teacherRepository.deleteById(teanum);
    }
}
