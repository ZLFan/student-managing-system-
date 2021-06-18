package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Basic;
import java.io.Serializable;

@Data
public class SCPrimaryKey implements Serializable {
    @Basic
    private String stunum;
    @Basic
    private String cornum;

    public void setCornum(String cornum) {
        this.cornum = cornum;
    }
    public void setStunum(String stunum){
        this.stunum = stunum;
    }

    public String getCornum() {
        return cornum;
    }

    public String getStunum() {
        return stunum;
    }
}
