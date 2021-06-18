package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
public class Course {
    @Id
    private String cornum;
    private String corname;
    private Integer corterm;
    private String corinfo;
    private Integer corcredit;
    private String teanum;
}

