package com.example.demo.entity;

import java.text.DecimalFormat;
import java.util.List;

public class Homestay {
    private int H_id;
    private String H_owner;
    private  String H_name;
    private String H_address;
    private String H_rule;
    private String  H_brief;
    private float H_score1;
    private float H_score2;
    private float H_score3;
    private float H_score4;
    private float H_allscore;
    private String picture;
    private String city;
    private String district;
    private int price;
    private int renqi;
    private String type;
    private String state;
    private String time;
    private List<Room> room;
    private List<Integer> roomType;
    private User user;
    private String distance;
    private int distanceN;
    private List<Comment> commentList;



    public List<Comment> getCommentList() {
        return commentList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    public void setDistanceN(int distanceN) {
        this.distanceN = distanceN;
    }
    public int getDistanceN() {
        return distanceN;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        System.out.println("dist:"+distance);
        if(Integer.parseInt(distance)>1000){
            DecimalFormat df =new DecimalFormat("#0.0");
            distance=df.format(Integer.parseInt(distance)/1000.0)+"公里";
        }else{
            distance=distance+"米";
        }
        System.out.println("dist:"+distance);
        this.distance = distance;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getRoomType() {
        return this.roomType;
    }
    public void setRoomType(List<Integer> roomType) {
        this.roomType = roomType;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public Homestay(int h_id, String h_owner, String h_name, String h_address, String h_rule, String h_brief, float h_score1, float h_score2, float h_score3, float h_score4, float h_allscore, String picture, String city, String district, int price, int renqi, String type, List<Room> room) {
        this.H_id = h_id;
        this.H_owner = h_owner;
        this.H_name = h_name;
        this.H_address = h_address;
        this.H_rule = h_rule;
        this.H_brief = h_brief;
        this.H_score1 = h_score1;
        this.H_score2 = h_score2;
        this.H_score3 = h_score3;
        this.H_score4 = h_score4;
        this.H_allscore = h_allscore;
        this.picture = picture;
        this.city = city;
        this.district = district;
        this.price = price;
        this.renqi = renqi;
        this.type = type;
        this.room = room;
    }
    public Homestay(){
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public float getH_allscore() {
        return H_allscore;
    }

    public void setH_allscore(float h_allscore) {
        DecimalFormat df =new DecimalFormat("#0.0");
        this.H_allscore = Float.parseFloat(df.format(h_allscore));
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public List<Room> getRoom() {
        return room;
    }
    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public int getH_id() {
        return this.H_id;
    }

    public void setH_id(int h_id) {
        this.H_id = h_id;
    }

    public String getH_owner() {
        return this.H_owner;
    }

    public void setH_owner(String h_owner) {
        this.H_owner = h_owner;
    }

    public String getH_name() {
        return this.H_name;
    }

    public void setH_name(String h_name) {
        this.H_name = h_name;
    }

    public String getH_address() {
        return this.H_address;
    }

    public void setH_address(String h_address) {
        this.H_address = h_address;
    }

    public String getH_rule() {
        return this.H_rule;
    }

    public void setH_rule(String h_rule) {
        this.H_rule = h_rule;
    }

    public String getH_brief() {
        return this.H_brief;
    }

    public void setH_brief(String h_brief) {
        this.H_brief = h_brief;
    }

    public float getH_score1() {
        return this.H_score1;
    }

    public void setH_score1(float h_score1) {
        this.H_score1 = h_score1;
    }

    public float getH_score2() {
        return this.H_score2;
    }

    public void setH_score2(float h_score2) {
        this.H_score2 = h_score2;
    }

    public float getH_score3() {
        return this.H_score3;
    }

    public void setH_score3(float h_score3) {
        this.H_score3 = h_score3;
    }

    public float getH_score4() {
        return this.H_score4;
    }

    public void setH_score4(float h_score4) {
        this.H_score4 = h_score4;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRenqi() {
        return this.renqi;
    }

    public void setRenqi(int renqi) {
        this.renqi = renqi;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
