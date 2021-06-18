package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(SCPrimaryKey.class)
public class SC {
    @Id
    private String stunum;
    @Id
    private String cornum;

    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStunum() {
        return stunum;
    }

    public String getCornum() {
        return cornum;
    }

    public void setCornum(String cornum) {
        this.cornum = cornum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }
}

