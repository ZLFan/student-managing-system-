package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(SGPrimaryKey.class)
public class SG {
    @Id
    private String stunum;
    @Id
    private String groupnum;

    public String getStunum() {
        return stunum;
    }

    public String getGroupnum() {
        return groupnum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public void setGroupnum(String groupnum) {
        this.groupnum = groupnum;
    }
}

