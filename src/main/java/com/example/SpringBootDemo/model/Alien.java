package com.example.SpringBootDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="alien")
public class Alien {
    @Id
    @Column(name = "aid")
    private int aid;

    @Column(name = "aname")
    private String aname;


    @Column(name = "st_date")
    private Date st_date;

    public Alien() {
    }

    public Alien(int aid, String aname, Date st_date) {
        this.aid = aid;
        this.aname = aname;
        this.st_date = st_date;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Date getst_date() {
        return st_date;
    }

    public void setst_date(Date st_date) {
        this.st_date = st_date;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", st_date=" + st_date +
                '}';
    }
}
