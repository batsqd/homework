package com.homework.model;

import java.util.Date;
public class Buyer {
    private String nickname;
    private String password;
    private Date register_time;
    public Buyer(){

    }
    public Buyer(String nickname,String password,Date register_time){
        this.nickname=nickname;
        this.password=password;
        this.register_time=register_time;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

}
