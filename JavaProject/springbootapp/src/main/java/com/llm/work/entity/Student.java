package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    private String stunum;
    private String stuname;
    private String stugender;
    private String stuidc;
    private Integer stuyear;
    private String stufrom;
}

