package com.team.geaStargram.vo;

import java.sql.Date;

public class Comment {

    private int cid;
    private int fkAccount;
    private int fkBoard;
    private String content;
    private Date createDate;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getFkAccount() {
        return fkAccount;
    }

    public void setFkAccount(int fkAccount) {
        this.fkAccount = fkAccount;
    }

    public int getFkBoard() {
        return fkBoard;
    }

    public void setFkBoard(int fkBoard) {
        this.fkBoard = fkBoard;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
