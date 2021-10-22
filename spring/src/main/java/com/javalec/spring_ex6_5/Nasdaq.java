package com.javalec.spring_ex6_5;

import java.util.ArrayList;

public class Nasdaq {
    private String stock;
    private String number;
    private ArrayList<String> model;

    public Nasdaq(String stock) {
        this.stock = stock;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<String> getModel() {
        return model;
    }

    public void setModel(ArrayList<String> model) {
        this.model = model;
    }
}
