package com.west.forlearn.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_family")
public class FamilyInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ffid")
    private long fid;

    @Column(name = "Fname")
    private String name;

    @Column(name = "Fbackurl")
    private String backurl;

    @Column(name = "Fcreate_user")
    private String createUser;

    @Column(name = "Fuser_num")
    private int userNum;

    @Column(name = "Fuser_list")
    private String userList;

    @Column(name = "Fstate")
    private int state;

    @Column(name = "Fsign")
    private String sign;

    @Column(name = "Fcreate_time")
    private String createTime;

    @Column(name = "Fmodify_time")
    private String modifyTime;

    @Column(name = "Fstanby1")
    private int standby1;

    @Column(name = "Fstanby2")
    private int standby2;

    @Column(name = "Fstanby3")
    private long standby3;

    @Column(name = "Fstanby4")
    private String standby4;

    @Column(name = "Fstanby5")
    private String standby5;

    @Column(name = "Fstanby6")
    private String standby6;

    @Column(name = "Fstanby7")
    private String standby7;

    @Column(name = "Fstanby8")
    private String standby8;

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public String getUserList() {
        return userList;
    }

    public void setUserList(String userList) {
        this.userList = userList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getStandby1() {
        return standby1;
    }

    public void setStandby1(int standby1) {
        this.standby1 = standby1;
    }

    public int getStandby2() {
        return standby2;
    }

    public void setStandby2(int standby2) {
        this.standby2 = standby2;
    }

    public long getStandby3() {
        return standby3;
    }

    public void setStandby3(long standby3) {
        this.standby3 = standby3;
    }

    public String getStandby4() {
        return standby4;
    }

    public void setStandby4(String standby4) {
        this.standby4 = standby4;
    }

    public String getStandby5() {
        return standby5;
    }

    public void setStandby5(String standby5) {
        this.standby5 = standby5;
    }

    public String getStandby6() {
        return standby6;
    }

    public void setStandby6(String standby6) {
        this.standby6 = standby6;
    }

    public String getStandby7() {
        return standby7;
    }

    public void setStandby7(String standby7) {
        this.standby7 = standby7;
    }

    public String getStandby8() {
        return standby8;
    }

    public void setStandby8(String standby8) {
        this.standby8 = standby8;
    }

    @Override
    public String toString() {
        return "FamilyInfo{" +
                "name='" + name + '\'' +
                ", backurl='" + backurl + '\'' +
                ", createUser='" + createUser + '\'' +
                ", userNum=" + userNum +
                ", userList='" + userList + '\'' +
                ", state=" + state +
                '}';
    }
}
