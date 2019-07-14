package com.csci3130.project.team1.model;

public class CannabisProduct {
    private String name;
    private String brand;
    private double THC;

    public CannabisProduct(String name, String brand, double THC) {
        this.name = name;
        this.brand = brand;
        this.THC = THC;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getTHC() {
        return THC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTHC(double THC) {
        this.THC = THC;
    }
}
