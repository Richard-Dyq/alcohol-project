package com.csci3130.project.team1.model;

public class CannabisProduct {
    private String name;
    private int brand;
    private double THC;
    private String url;


    public CannabisProduct() {
    }

    public CannabisProduct(String name, int brand, double THC) {
        this.name = name;
        this.brand = brand;
        this.THC = THC;
    }

    /**
     * Getter and Setter Methods
     */

    public String getName() {
        return name;
    }

    public int getBrand() {
        return brand;
    }

    public double getTHC() {
        return THC;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getBrandLiteral(){
        return CannabisType.getInstance().allTypes.get((int)brand);
    }

    public void setTHC(double THC) {
        this.THC = THC;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
