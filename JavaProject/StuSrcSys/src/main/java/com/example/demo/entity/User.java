package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User
{
    @Id
    @GeneratedValue
    private long id;
    private Integer tab;
    private Integer getTab()
    {
        return tab;
    }
    private void setTab(Integer tab)
    {
        this.tab=tab;
    }
    @Column(length = 32)
    private String username;
    @Column(length = 64)
    private String password;
    public Long getId()
    {
        return id;
    }
    public void setId()
    {
        this.id=id;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
}
