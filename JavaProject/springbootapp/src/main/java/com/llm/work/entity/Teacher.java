package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Teacher {
    @Id
    private String teanum;
    private String teaname;
    private String teaidc;
    private String teaflag;
    private String pos;

    public String getTeaname() {
        return teaname;
    }
}

