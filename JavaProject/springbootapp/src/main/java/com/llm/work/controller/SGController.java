package com.llm.work.controller;

import com.llm.work.entity.SG;
import com.llm.work.entity.SGPrimaryKey;
import com.llm.work.repository.SGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sg")

public class SGController {
    @Autowired
    private SGRepository sgRepository;
    @GetMapping("/findAll")
    public List<SG> findAll()
    {
        return sgRepository.findAll();
    }
    @PostMapping("/save")
    public String save(@RequestBody SG sg)
    {
        SG result = sgRepository.save(sg);
        if(result!=null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }
    //根据主键查找
    @GetMapping("/findById/{stunum}/{groupnum}")
    public SG findById(@PathVariable("stunum") String stunum, @PathVariable("groupnum") String groupnum)
    {
        SGPrimaryKey sgp = new SGPrimaryKey();
        sgp.setGroupnum(groupnum);
        sgp.setStunum(stunum);
        return sgRepository.findById(sgp).get();
    }
    //stunum
    @GetMapping("/findByStunum/{stunum}")
    public List <SG> findByTeanum(@PathVariable("stunum")String stunum){
        return sgRepository.findByStunum(stunum);
    }

    @GetMapping("/findByGroupnum/{groupnum}")
    public List <SG> findByGroupnum(@PathVariable("groupnum")String groupnum){
        return sgRepository.findByGroupnum(groupnum);
    }
    //    public TC findById(@PathVariable("teanum") String teanum)
//    {
//        return tcRepository.findById(teanum).get();
//    }
    //delete by primary keys
    @DeleteMapping("/deleteById/{stunum}/{groupnum}")
    public void deleteByMapping(@PathVariable("stunum") String stunum, @PathVariable("groupnum") String groupnum)
    {
        SGPrimaryKey tcp = new SGPrimaryKey();
        tcp.setGroupnum(groupnum);
        tcp.setStunum(stunum);
        sgRepository.deleteById(tcp);
    }
    //List<TC> deleteByTeanum(String teanum);
    //delete by teacher number
    @DeleteMapping("/deleteByStunum/{stunum}")
    public void deleteByStunum(@PathVariable("stunum") String stunum)
    {
        sgRepository.deleteByStunum(stunum);
    }
    //delete by course number
    @DeleteMapping("/deleteByGroupnum/{groupnum}")
    public void deleteByGroupnum(@PathVariable("groupnum") String groupnum)
    {
        sgRepository.deleteByGroupnum(groupnum);
    }
}
