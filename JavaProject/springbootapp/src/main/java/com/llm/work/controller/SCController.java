package com.llm.work.controller;

import com.llm.work.entity.SC;
import com.llm.work.entity.SCPrimaryKey;
import com.llm.work.repository.SCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sc")

public class SCController {
    @Autowired
    private SCRepository scRepository;
    @GetMapping("/findAll")
    public List<SC> findAll()
    {
        return scRepository.findAll();
    }
    @PostMapping("/save")
    public String save(@RequestBody SC sc)
    {
        SC result = scRepository.save(sc);
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
    @GetMapping("/findById/{stunum}/{cornum}")
    public SC findById(@PathVariable("stunum") String stunum, @PathVariable("cornum") String cornum)
    {
        SCPrimaryKey scp = new SCPrimaryKey();
        scp.setCornum(cornum);
        scp.setStunum(stunum);
        return scRepository.findById(scp).get();
    }
    //stunum
    @GetMapping("/findByStunum/{stunum}")
    public List <SC> findByTeanum(@PathVariable("stunum")String stunum){
        return scRepository.findByStunum(stunum);
    }

    @GetMapping("/findByCornum/{cornum}")
    public List <SC> findByCornum(@PathVariable("cornum")String cornum){
        return scRepository.findByCornum(cornum);
    }
    //    public TC findById(@PathVariable("teanum") String teanum)
//    {
//        return tcRepository.findById(teanum).get();
//    }
    //delete by primary keys
    @DeleteMapping("/deleteById/{stunum}/{cornum}")
    public void deleteByMapping(@PathVariable("stunum") String stunum, @PathVariable("cornum") String cornum)
    {
        SCPrimaryKey tcp = new SCPrimaryKey();
        tcp.setCornum(cornum);
        tcp.setStunum(stunum);
        scRepository.deleteById(tcp);
    }
    //List<TC> deleteByTeanum(String teanum);
    //delete by teacher number
    @DeleteMapping("/deleteByStunum/{stunum}")
    public void deleteByStunum(@PathVariable("stunum") String stunum)
    {
        scRepository.deleteByStunum(stunum);
    }
    //delete by course number
    @DeleteMapping("/deleteByCornum/{cornum}")
    public void deleteByCornum(@PathVariable("cornum") String cornum)
    {
        scRepository.deleteByCornum(cornum);
    }
}
