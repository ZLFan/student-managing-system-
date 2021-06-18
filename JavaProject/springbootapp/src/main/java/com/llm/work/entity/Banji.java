package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Banji {
    @Id
    private String groupnum;

    private String teanum;
    private String headmaster;
    private String life;
    private String study;

    public void setTeanum(String teanum) {
        this.teanum = teanum;
    }

    public String getTeanum() {
        return teanum;
    }

    public String getGroupnum() {
        return groupnum;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public String getLife() {
        return life;
    }

    public String getStudy() {
        return study;
    }

    public void setGroupnum(String groupnum) {
        this.groupnum = groupnum;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public void setStudy(String study) {
        this.study = study;
    }
}

