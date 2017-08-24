package com.team.geaStargram.vo;

public class Account {

    private int userid;
    private String email;
    private String password;
    private String birth;
    private String nickName;
    private int cnt;
    private boolean atholization;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public boolean isAtholization() {
        return atholization;
    }

    public void setAtholization(boolean atholization) {
        this.atholization = atholization;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userid='" + userid + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birth='" + birth + '\'' +
                ", nickName='" + nickName + '\'' +
                ", count=" + cnt +
                ", atholization=" + atholization +
                '}';
    }
}
