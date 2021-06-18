package com.llm.work.controller;

import com.llm.work.entity.Login;
import com.llm.work.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/login")

public class LoginController {
    @Autowired
    private LoginRepository loginRepository;
    @GetMapping("/findAll")
    public List<Login> findAll()
    {
        //Pageable pageable = PageRequest.of(page,size);
        return loginRepository.findAll();
    }
    @GetMapping("test/{username}/{password}")
    public Integer test(@PathVariable("username") String username,@PathVariable("password") String password)
    {
//        System.out.println("user:"+username+'\n');
//        System.out.println("pass:"+password+'\n');
        Login account = loginRepository.findById(username).get();
//        System.out.println("user:"+account.getUsername()+'\n');
//        System.out.println("pass:"+account.getPassword()+'\n');
//        System.out.println("is user:"+username.equals(account.getUsername())+'\n');
//        System.out.println("is pass:"+password.equals(account.getPassword())+'\n');
        if((username.equals(account.getUsername()))&&(password.equals(account.getPassword())))
        {
            return account.getFlag();
        }
        else
        {
            return 5;
        }
    }
    @GetMapping("/getLogFlag/{username}")
    public Integer getLogFlag(@PathVariable("username") String username){
        return loginRepository.getLogFlag(username).getFlag();
    }
    @PostMapping("/save")
    public String save(@RequestBody Login login)
    {
        Login result = loginRepository.save(login);
        if(result!=null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }
    @PostMapping("/saveId/{username}/{password}/{flag}")
    public String saveId(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("flag") Integer flag)
    {
        Login login=new Login(username,password,flag);
        Login result = loginRepository.save(login);
        if(result!=null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }
    @GetMapping("/findById/{username}")
    public Login findById(@PathVariable("username") String username)
    {
        return loginRepository.findById(username).get();
    }
    @DeleteMapping("/deleteById/{username}")
    public void deleteByMapping(@PathVariable("username") String username)
    {
        loginRepository.deleteById(username);
    }
}
