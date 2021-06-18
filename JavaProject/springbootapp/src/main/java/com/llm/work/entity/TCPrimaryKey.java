package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Basic;
import java.io.Serializable;

@Data
public class TCPrimaryKey implements Serializable {
    @Basic
    private String teanum;
    @Basic
    private String cornum;

    public void setCornum(String cornum) {
        this.cornum = cornum;
    }
    public void setTeanum(String teanum){
        this.teanum = teanum;
    }

    public String getCornum() {
        return cornum;
    }

    public String getTeanum() {
        return teanum;
    }
}
