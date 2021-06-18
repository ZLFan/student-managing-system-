package com.llm.work.controller;

import com.llm.work.entity.Banji;
import com.llm.work.repository.BanjiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/banji")

public class BanjiController {
    @Autowired
    private BanjiRepository banjiRepository;
    @GetMapping("/findAll")
    public List<Banji> findAll()
    {
        return banjiRepository.findAll();
    }
    @PostMapping("/save")
    public String save(@RequestBody Banji banji)
    {
        Banji result = banjiRepository.save(banji);
        if(result!=null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }
    @GetMapping("/findById/{groupnum}")
    public Banji findById(@PathVariable("groupnum") String groupnum)
    {
        return banjiRepository.findById(groupnum).get();
    }
    @GetMapping("/findByTeanum/{teanum}")
    public Banji findByTeanum(@PathVariable("teanum") String teanum)
    {
        return banjiRepository.findByTeanum(teanum);
    }
    @DeleteMapping("/deleteById/{groupnum}")
    public void deleteByMapping(@PathVariable("groupnum") String groupnum)
    {
        banjiRepository.deleteById(groupnum);
    }
}
