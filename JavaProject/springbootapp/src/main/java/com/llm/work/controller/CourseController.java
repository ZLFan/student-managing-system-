package com.llm.work.controller;

import com.llm.work.entity.Course;
import com.llm.work.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")

public class CourseController {
    @Autowired
        private CourseRepository courseRepository;
    @GetMapping("/findAll")
    public List<Course> findAll()
    {
        //Pageable pageable = PageRequest.of(page,size);
        return courseRepository.findAll();
    }
    @PostMapping("/save")
    public String save(@RequestBody Course course)
    {
        Course result = courseRepository.save(course);
        if(result!=null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }
    @GetMapping("/findById/{cornum}")
    public Course findById(@PathVariable("cornum") String cornum)
    {
        return courseRepository.findById(cornum).get();
    }
    @GetMapping("/findByTeanum/{teanum}")
    public Course findByTeanum(@PathVariable("teanum") String teanum)
    {
            return courseRepository.findByTeanum(teanum).get(0);
    }

    @DeleteMapping("/deleteById/{cornum}")
    public void deleteByMapping(@PathVariable("cornum") String cornum)
    {
        courseRepository.deleteById(cornum);
    }
}
