package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Login {
    @Id
    private String username;
    private String password;
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public Login(String username,String password,Integer flag)
    {
        this.username=username;
        this.password=password;
        this.flag=flag;
    }
    public Login()
    {

    }
}

