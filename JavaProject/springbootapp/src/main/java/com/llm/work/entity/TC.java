package com.llm.work.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(TCPrimaryKey.class)
public class TC {
    @Id
    private String teanum;
    @Id
    private String cornum;

    public String getTeanum() {
        return teanum;
    }

    public String getCornum() {
        return cornum;
    }

    public void setCornum(String cornum) {
        this.cornum = cornum;
    }

    public void setTeanum(String teanum) {
        this.teanum = teanum;
    }
}

