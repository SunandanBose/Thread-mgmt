package com.chargebee.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Job {


    public Job(int id, String companyname, String offeredSalary){
        this.id = id;
        this.companyname = companyname;
        this.offeredSalary = offeredSalary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String companyname;

    public String jobdescription;

    public Date createdTime;

    public Date updatedTime;

    public String offeredSalary;

    
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @PrePersist
    protected void onCreate() {
        createdTime = new Date();
    }
}
