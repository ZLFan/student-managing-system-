package com.llm.work.controller;

import com.llm.work.entity.TC;
import com.llm.work.entity.TCPrimaryKey;
import com.llm.work.repository.TCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tc")

public class TCController {
    @Autowired
    private TCRepository tcRepository;
    @GetMapping("/findAll")
    public List<TC> findAll()
    {
        return tcRepository.findAll();
    }
    @PostMapping("/save")
    public String save(@RequestBody TC tc)
    {
        TC result = tcRepository.save(tc);
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
    @GetMapping("/findById/{teanum}/{cornum}")
    public TC findById(@PathVariable("teanum") String teanum, @PathVariable("cornum") String cornum)
    {
        TCPrimaryKey tcp = new TCPrimaryKey();
        tcp.setCornum(cornum);
        tcp.setTeanum(teanum);
        return tcRepository.findById(tcp).get();
    }
    //根据教师号查找
    @GetMapping("/findByTeanum/{teanum}")
    public List <TC> findByTeanum(@PathVariable("teanum")String teanum){
        return tcRepository.findByTeanum(teanum);
    }
    //根据课程号查找
    @GetMapping("/findByCornum/{cornum}")
    public List <TC> findByCornum(@PathVariable("cornum")String cornum){
        return tcRepository.findByCornum(cornum);
    }
//    public TC findById(@PathVariable("teanum") String teanum)
//    {
//        return tcRepository.findById(teanum).get();
//    }
    //delete by primary keys
    @DeleteMapping("/deleteById/{teanum}/{cornum}")
    public void deleteByMapping(@PathVariable("teanum") String teanum, @PathVariable("cornum") String cornum)
    {
        TCPrimaryKey tcp = new TCPrimaryKey();
        tcp.setCornum(cornum);
        tcp.setTeanum(teanum);
        tcRepository.deleteById(tcp);
    }
    //List<TC> deleteByTeanum(String teanum);
    //delete by teacher number
    @DeleteMapping("/deleteByTeanum/{teanum}")
    public void deleteByTeanum(@PathVariable("teanum") String teanum)
    {
        tcRepository.deleteByTeanum(teanum);
    }
    //delete by course number
    @DeleteMapping("/deleteByCornum/{cornum}")
    public void deleteByCornum(@PathVariable("cornum") String cornum)
    {
        tcRepository.deleteByCornum(cornum);
    }
}
