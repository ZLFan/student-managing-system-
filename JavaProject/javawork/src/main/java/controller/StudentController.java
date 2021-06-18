package controller;

import entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class StudentController
{
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping(value = "saveStu")
    public String saveStu(Integer stuid,String stuname,String stuidc,Integer stuyear,String stufrom){
        Student stu = new Student(stuid,stuname,stuidc,stuyear,stufrom);
        studentRepository.save(stu);
        return "success";
    }

    //http://localhost:8888/deleteCity?cityId=2
    @GetMapping(value = "deleteStu")
    @Modifying
    public String deleteStu(Student stu){
        studentRepository.delete(stu);
        return "success";
    }

    //http://localhost:8888/updateCity?cityId=3&cityName=沈阳&cityIntroduce=辽宁省省会
    @GetMapping(value = "updateStu")
    public String updateCity(Integer stuid,String stuname,String stuidc,Integer stuyear,String stufrom){
        Student stu = new Student(stuid,stuname,stuidc,stuyear,stufrom);
        studentRepository.save(stu);
        return "success";
    }

    //http://localhost:8888/getCityById?cityId=3
    @GetMapping(value = "getStuById")
    public Student getStuById(Integer stuid){
        //Student stu = studentRepository.findOne(stuid);
        Student stu = studentRepository.findById(stuid).orElse(null);
        return stu;
    }
}