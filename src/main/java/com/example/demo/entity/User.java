package com.example.demo.entity;

public class User {
    private int user_id;
    private String user_name;
    private int user_sex;



    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", name='" + user_name + '\'' +
                ", age=" + user_sex +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }
}
