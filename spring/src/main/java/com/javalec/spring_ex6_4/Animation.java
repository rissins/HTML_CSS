package com.javalec.spring_ex6_4;

import java.util.ArrayList;

public class Animation {
    private String title;
    private String date;
    private ArrayList<String> member;

    public Animation(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<String> getMember() {
        return member;
    }

    public void setMember(ArrayList<String> member) {
        this.member = member;
    }
}
