package com.west.forlearn.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="simple_user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Fbkid")
    private Long id;

    @Column(name = "Fname")
    private String name;

    @Column(name = "Fdesc")
    private String desc;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
}
