package com.xiaojihua.domain;

import java.io.Serializable;
import java.util.Objects;

public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String userName;
    private String passWord;


    public Users() {
    }

    public Users(int id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(userName, users.userName) &&
                Objects.equals(passWord, users.passWord);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, passWord);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
