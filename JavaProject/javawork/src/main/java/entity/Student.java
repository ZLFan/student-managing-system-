package entity;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="student")
public class Student
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer stuid;
    private String stuname;
    private String stuidc;
    private String stufrom;
    private Integer stuyear;

    public Student() {
        this.stuid=stuid;
        this.stuname=stuname;
        this.stuidc=stuidc;
        this.stuyear=stuyear;
        this.stufrom=stufrom;
    }

    @Override
    public String toString()
    {
        return "{" +
                "  stuid='" + getId() + "'" +
                ", stuname='" + getName() + "'" +
                ", stuidc='" + getIdc() + "'" +
                ", stuyear='" + getYear() + "'" +
                ", stufrom='" + getFrom() + "'" +
                "}";
    }
    public Student(Integer stuid,String stuname,String stuidc,Integer stuyear,String stufrom)
    {
        this.stuid=stuid;
        this.stuname=stuname;
        this.stuidc=stuidc;
        this.stuyear=stuyear;
        this.stufrom=stufrom;
    }
    public Integer getId()
    {
        return this.stuid;
    }
    public String getName()
    {
        return this.stuname;
    }
    public String getIdc()
    {
        return this.stuidc;
    }
    public Integer getYear()
    {
        return this.stuyear;
    }
    public String getFrom()
    {
        return this.stufrom;
    }
    public void setId(Integer stuid)
    {
        this.stuid=stuid;
    }
    public void setName(String stuname)
    {
        this.stuname=stuname;
    }
    public void setIdc(String stuidc)
    {
        this.stuidc=stuidc;
    }
    public void setYear(Integer stuyear)
    {
        this.stuyear=stuyear;
    }
    public void setFrom()
    {
        this.stufrom=stufrom;
    }
}