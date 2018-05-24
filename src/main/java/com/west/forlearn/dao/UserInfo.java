package com.west.forlearn.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_user")
public class UserInfo implements Serializable {

    @Id
    @Column(name = "Fopenid")
    private String openid;

    @Column(name = "Fname")
    private String name;

    @Column(name = "Favatar_url")
    private String avatarUrl;

    @Column(name = "Fgender")
    private  String gender;

    @Column(name = "Fposition")
    private String position;

    @Column(name = "Ffamily_num")
    private int familyNum;

    @Column(name = "Ffamily_list")
    private String familyList;

    @Column(name = "Ffirst_fid")
    private Long firstFid;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFamilyNum() {
        return familyNum;
    }

    public void setFamilyNum(int familyNum) {
        this.familyNum = familyNum;
    }

    public String getFamilyList() {
        return familyList;
    }

    public void setFamilyList(String familyList) {
        this.familyList = familyList;
    }

    public Long getFirstFid() {
        return firstFid;
    }

    public void setFirstFid(Long firstFid) {
        this.firstFid = firstFid;
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
        return "UserInfo{" +
                "openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", position='" + position + '\'' +
                ", familyNum=" + familyNum +
                ", familyList='" + familyList + '\'' +
                ", firstFid='" + firstFid + '\'' +
                ", state=" + state +
                '}';
    }
}
