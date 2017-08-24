package com.team.geaStargram.vo;

import java.sql.Date;

public class TimeLine {

    private int tid;
    private int fkAccount;
    private String content;
    private String sumnailImgPath;
    private String mainImgPath;
    private int likeCnt;
    private Date createDate;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getFkAccount() {
        return fkAccount;
    }

    public void setFkAccount(int fkAccount) {
        this.fkAccount = fkAccount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSumnailImgPath() {
        return sumnailImgPath;
    }

    public void setSumnailImgPath(String sumnailImgPath) {
        this.sumnailImgPath = sumnailImgPath;
    }

    public String getMainImgPath() {
        return mainImgPath;
    }

    public void setMainImgPath(String mainImgPath) {
        this.mainImgPath = mainImgPath;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
