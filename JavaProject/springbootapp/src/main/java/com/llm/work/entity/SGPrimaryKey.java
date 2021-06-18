package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Basic;
import java.io.Serializable;

@Data
public class SGPrimaryKey implements Serializable {
    @Basic
    private String stunum;
    @Basic
    private String groupnum;

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }
    public void setGroupnum(String groupnum){
        this.groupnum = groupnum;
    }

    public String getStunum() {
        return stunum;
    }

    public String getGroupnum() {
        return groupnum;
    }
}
